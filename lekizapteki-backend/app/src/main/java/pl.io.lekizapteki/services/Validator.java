package pl.io.lekizapteki.services;

import java.util.ArrayList;
import java.util.List;

public class Validator {

  public static List<Medicine> filter(List<Medicine> medicines) {
    return filterInvalidMedicines(medicines);
  }

  public static List<Medicine> filterInvalidMedicines(List<Medicine> medicinesToValidate) {
    List<Medicine> validatedMedicines = new ArrayList<>();

    for (Medicine medicineToValidate : medicinesToValidate) {
      if (isValidMedicine(medicineToValidate)) {
        validatedMedicines.add(medicineToValidate);
      }
    }

    return validatedMedicines;
  }

  private static boolean isValidMedicine(Medicine medicine) {
    // pojedyncza substancja czynna -> zawartość komórki 'substancja czynna' nie ma w sobie znaku +
    // tylko w formie tabletek -> zawartość komórki 'nazwa, postać, dawka', jakoś sprawdzić postać
    // moze jeszcze jakies nwm
    return true;
  }
}
