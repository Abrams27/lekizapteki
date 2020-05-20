package pl.io.lekizapteki.parseExcel.test;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.io.lekizapteki.parseExcel.ExcelParser;
import pl.io.lekizapteki.repositories.excelDatatypes.Medicine;


public class CreateEntitiesFromExcelTest {

  @Test
  public void excelParserTest() {
    String filePath = "src/main/resources/wykaz.xlsx";
    ExcelParser excelParser = new ExcelParser();

    List<Medicine> medicines = excelParser.parseExcelFile(filePath);

    assert (medicines.size() == 4312);
    for (Medicine medicine : medicines) {
      System.out.println(medicine.toString());
    }
  }

  // będą dodawane pozniej testy do mapowań medicine -> entity
}
