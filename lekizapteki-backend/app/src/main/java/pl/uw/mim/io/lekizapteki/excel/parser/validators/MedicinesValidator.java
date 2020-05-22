package pl.uw.mim.io.lekizapteki.excel.parser.validators;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.MedicineParser;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.UnitConverter;

@UtilityClass
public class MedicinesValidator {

  private final String MULTIPLE_INGREDIENT_DELIMITER = "+";
  private final String PILL_FORM_SUBSTRING = "tabl";
  private final String SPECIAL_MEDICINE_PACK_PREFIX = "1 but.po";

  public List<Medicine> filterAndParse(List<Medicine> medicines) {

    List<Medicine> filteredMedicines = filterInvalidMedicines(medicines);

    return parseMedicines(filteredMedicines);
  }

  private List<Medicine> filterInvalidMedicines(List<Medicine> medicinesToValidate) {
    List<Medicine> validatedMedicines = new ArrayList<>();

    for (Medicine medicineToValidate : medicinesToValidate) {
      if (isValidMedicine(medicineToValidate)) {
        validatedMedicines.add(medicineToValidate);
      }
    }

    return validatedMedicines;
  }

  private boolean isValidMedicine(Medicine medicine) {
    return hasSingleIngredient(medicine) && hasPillForm(medicine);
  }

  private boolean hasSingleIngredient(Medicine medicine) {
    return !medicine.getIngredient().contains(MULTIPLE_INGREDIENT_DELIMITER);
  }

  private boolean hasPillForm(Medicine medicine) {
    return medicine.getNameAndFormAndDose().contains(PILL_FORM_SUBSTRING);
  }

  private List<Medicine> parseMedicines(List<Medicine> medicines) {

    List<Medicine> parsedMedicines = new ArrayList<>();

    for (Medicine medicine : medicines) {
      parsedMedicines.add(parseMedicine(medicine));
    }

    return parsedMedicines;
  }

  public Medicine parseMedicine(Medicine medicine) {
    MedicineParser medicineParser = new MedicineParser();

    medicineParser.parseMedicine(medicine);
    String name = medicineParser.getName();
    String form = medicineParser.getForm();
    String dose = medicineParser.getDose();
    String pack = medicine.getPack();


    String parsedDose = parseMedicineDose(dose);
    String parsedPack = parseMedicinePack(pack);

    medicine.setNameAndFormAndDose(putNameAndFormAndDoseTogether(name, form, parsedDose));
    medicine.setPack(parsedPack);

    return medicine;
  }

  private String parseMedicineDose(String dose) {
    String[] split = dose.split(" ");

    if (split.length > 2) {
      return parseSpecialMedicineDose(dose);
    }

    String value = split[0];
    String units = split[1];

    switch (units) {
      case "g":
        value = UnitConverter.gramsToMilligrams(value);
        break;
      case "µg": // to nie jest ten sam znaczek co niżej xd
      case "μg":
        value = UnitConverter.microgramsToMilligrams(value);
        break;
      case "j.m.":
        value = UnitConverter.internationalUnitsToMilligrams(value);
        break;
    }

    return putDoseBackTogether(value, "mg");
  }

  // są to dawki postaci 1.5 mln j.m. i 3 mln j.m.
  private String parseSpecialMedicineDose(String specialDose) {

    final int MLN = 1000000000;

    String[] split = specialDose.split(" ");

    String value = split[0];

    BigDecimal decimalValue = new BigDecimal(value);
    decimalValue = decimalValue.multiply(BigDecimal.valueOf(MLN));

    value = UnitConverter.internationalUnitsToMilligrams(decimalValue.toString());

    return putDoseBackTogether(value, "mg");
  }

  private String parseMedicinePack(String pack) {
    String[] split = pack.split(" ");

    if (pack.startsWith(SPECIAL_MEDICINE_PACK_PREFIX)) {
      return putPackageBackTogether(split[2]);
    }

    return putPackageBackTogether(split[0]);
  }

  private String putNameAndFormAndDoseTogether(String name, String form, String dose) {
    return name + ", " + form + ", " + dose;
  }

  private String putDoseBackTogether(String value, String units) {
    return value + " " + units;
  }

  private String putPackageBackTogether(String value) {
    return value + " szt.";
  }
}
