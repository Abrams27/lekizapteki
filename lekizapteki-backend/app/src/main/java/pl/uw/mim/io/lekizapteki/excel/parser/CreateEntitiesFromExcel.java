package pl.uw.mim.io.lekizapteki.excel.parser;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.excel.parser.ExcelParser;
import pl.uw.mim.io.lekizapteki.excel.parser.MapMedicinesToEntities;
import pl.uw.mim.io.lekizapteki.excel.parser.MedicinesValidator;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.excelDatatypes.Medicine;

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
