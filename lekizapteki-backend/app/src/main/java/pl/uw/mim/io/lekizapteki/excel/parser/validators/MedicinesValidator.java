package pl.uw.mim.io.lekizapteki.excel.parser.validators;

import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;

@UtilityClass
public class MedicinesValidator {

  final String MULTIPLE_INGREDIENT_DELIMITER = " + ";
  final String PILL_FORM_SUBSTRING = "tabl";

  public List<Medicine> filter(List<Medicine> medicines) {
    return filterInvalidMedicines(medicines);
  }

  public List<Medicine> filterInvalidMedicines(List<Medicine> medicinesToValidate) {
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

}
