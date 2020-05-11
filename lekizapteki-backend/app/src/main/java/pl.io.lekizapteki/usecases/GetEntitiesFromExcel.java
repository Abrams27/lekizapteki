package pl.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.services.ExcelParser;
import pl.io.lekizapteki.services.JSONConverter;
import pl.io.lekizapteki.services.Medicine;
import pl.io.lekizapteki.services.Validator;

@Component
@AllArgsConstructor
public class GetEntitiesFromExcel {

  private final String filePath = "src/main/resources/wykaz.xlsx";
  private ExcelParser excelParser;
  private JSONConverter<List<Medicine>> jsonConverter;

  public void execute() {
    List<Medicine> medicines = excelParser.parseExcelFile(filePath);
    List<Medicine> validatedMedicines = Validator.validate(medicines);

    String medicinesJson = jsonConverter.convertObjectsToJsonString(validatedMedicines);

    // TODO
    // MapToEntitiesService.map(medicinesJson);
  }
}
