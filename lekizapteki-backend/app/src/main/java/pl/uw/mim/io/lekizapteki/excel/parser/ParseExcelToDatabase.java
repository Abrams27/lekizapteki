package pl.uw.mim.io.lekizapteki.excel.parser;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.excel.parser.validators.MedicinesValidator;
import pl.uw.mim.io.lekizapteki.services.MedicineService;

@Component
@AllArgsConstructor
public class ParseExcelToDatabase {

  private final static String FILE_PATH = "src/main/resources/wykaz.xlsx"; // przeniesc do properties

  private final ExcelParser excelParser;
  private final MedicineService medicineService;

  public void execute() {
    List<Medicine> medicines = excelParser.parseExcelFile(FILE_PATH);
    List<Medicine> validatedMedicines = MedicinesValidator.filter(medicines);
    medicineService.map(validatedMedicines);
  }
}
