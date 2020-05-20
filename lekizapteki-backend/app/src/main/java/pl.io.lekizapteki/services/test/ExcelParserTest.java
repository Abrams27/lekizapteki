package pl.io.lekizapteki.services.test;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.io.lekizapteki.services.ExcelParser;
import pl.io.lekizapteki.services.Medicine;

public class ExcelParserTest {

  private static List<Medicine> medicines;

  @BeforeAll
  static void setUp() {
    String filePath = "src/main/resources/wykaz.xlsx";
    ExcelParser excelParser = new ExcelParser();

    medicines = excelParser.parseExcelFile(filePath);
  }

  @Test
  public void isCorrectMedicinesCount() {
    assert(medicines.size() == 4312);
  }



  @Test
  public void stdoutAllMedicines() {
    for (Medicine medicine : medicines) {
      System.out.println(medicine.toString());
    }
  }
}
