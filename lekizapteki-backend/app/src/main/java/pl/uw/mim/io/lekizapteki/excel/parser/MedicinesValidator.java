package pl.uw.mim.io.lekizapteki.excel.parser;

import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.excelDatatypes.Medicine;

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
    // pojedyncza substancja czynna -> zawartość komórki 'substancja czynna' nie ma w sobie znaku +
    // tylko w formie tabletek -> zawartość komórki 'nazwa, postać, dawka', jakoś sprawdzić postać
    // moze jeszcze jakies nwm
    return true;
  }
}
