package pl.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.services.ExcelParser;
import pl.io.lekizapteki.services.MapMedicinesToEntities;
import pl.io.lekizapteki.services.Medicine;
import pl.io.lekizapteki.services.Validator;

@Component
@AllArgsConstructor
public class GetEntitiesFromExcel {

  private final static String FILE_PATH = "src/main/resources/wykaz.xlsx"; // przeniesc do properties
  private final ExcelParser excelParser;

  public void execute() {
    List<Medicine> medicines = excelParser.parseExcelFile(FILE_PATH);
    List<Medicine> validatedMedicines = Validator.filter(medicines);
    MapMedicinesToEntities.map(validatedMedicines);
  }
}
