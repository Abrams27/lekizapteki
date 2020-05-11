package pl.io.lekizapteki.services;

import java.util.List;

public class GenerateEntitiesFromExcel {
  private final String filePath = "src/main/resources/wykaz.xlsx";

  public void execute() {
    ExcelParser excelParser = new ExcelParser();
    List<Medicine> medicines = excelParser.parseExcelFile(filePath);
    List<Medicine> validatedMedicines = Validator.validate(medicines);

    JSONConverter<List<Medicine>> jsonConverter = new JSONConverter<>();
    String medicinesJson = jsonConverter.convertObjectsToJsonString(validatedMedicines);

    // TODO
    // MapToEntitiesService.map(medicinesJson);
  }
}
