package pl.io.lekizapteki.services;

import java.util.ArrayList;
import java.util.List;

public class Validator {
  private static final String filePath = "src/main/resources/wykaz.xlsx";

  public static List<Medicine> validate(List<Medicine> medicines) {
    return filterInvalidMedicines(medicines);

//    JSONConverter<List<Medicine>> jsonConverter = new JSONConverter<>();
//    String medicinesJson = jsonConverter.convertObjectsToJsonString(medicineList);
//    System.out.println(medicinesJson);
  }

  public static List<Medicine> filterInvalidMedicines(List<Medicine> medicinesToValidate) {
    // TODO
    // pojedyncza substancja czynna -> zawartość komórki 'substancja czynna' nie ma w sobie znaku +
    // tylko w formie tabletek -> zawartość komórki 'nazwa, postać, dawka', jakoś sprawdzić postać
    List<Medicine> validatedMedicines = new ArrayList<>();

    // TODO validate medicinesToValidate

    return validatedMedicines;
  }

  private static boolean isValidMedicine(Medicine medicine) {
    // TODO
    return true;
  }
}
