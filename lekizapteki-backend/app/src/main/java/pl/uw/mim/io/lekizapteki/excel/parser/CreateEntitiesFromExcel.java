package pl.uw.mim.io.lekizapteki.excel.parser;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.excel.parser.mappers.MedicinesToEntitiesMapper;
import pl.uw.mim.io.lekizapteki.excel.parser.validators.MedicinesValidator;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;

@Component
@AllArgsConstructor
public class CreateEntitiesFromExcel {

  private final static String FILE_PATH = "src/main/resources/wykaz.xlsx"; // przeniesc do properties
  private final ExcelParser excelParser;

  public void execute() {
    List<Medicine> medicines = excelParser.parseExcelFile(FILE_PATH);
    List<Medicine> validatedMedicines = MedicinesValidator.filter(medicines);
    MedicinesToEntitiesMapper.map(validatedMedicines);
  }
}
