package pl.uw.mim.io.lekizapteki.excel.parser.validators;

import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;

@UtilityClass
public class MedicinesValidator {

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
    // 1. ma być pojedyncza substancja czynna
    // 2. jedyna dopuszczalna forma to tabletki'
    // 3. TODO zweryfikować disease
    return hasSingleIngredient(medicine) && hasPillForm(medicine);
  }

  // pojedyncza substancja czynna -> zawartość komórki 'substancja czynna' nie ma w sobie znaku +
  private boolean hasSingleIngredient(Medicine medicine) {
    return !medicine.getIngredient().contains(" + ");
  }

  // tylko w formie tabletek -> zawartość komórki 'nazwa, postać, dawka' ma w sobie podciąg 'tabl'
  private boolean hasPillForm(Medicine medicine) {
    return medicine.getNameAndFormAndDose().contains("tabl");
  }

  // TODO zweryfikować disease

}
