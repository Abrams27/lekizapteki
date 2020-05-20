package pl.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.parseExcel.ExcelParser;
import pl.io.lekizapteki.parseExcel.MapMedicinesToEntities;
import pl.io.lekizapteki.parseExcel.MedicinesValidator;
import pl.io.lekizapteki.repositories.excelDatatypes.Medicine;

@Component
@AllArgsConstructor
public class CreateEntitiesFromExcel {

  private final static String FILE_PATH = "src/main/resources/wykaz.xlsx"; // przeniesc do properties
  private final ExcelParser excelParser;

  public void execute() {
    List<Medicine> medicines = excelParser.parseExcelFile(FILE_PATH);
    List<Medicine> validatedMedicines = MedicinesValidator.filter(medicines);
    MapMedicinesToEntities.map(validatedMedicines);
  }
}
