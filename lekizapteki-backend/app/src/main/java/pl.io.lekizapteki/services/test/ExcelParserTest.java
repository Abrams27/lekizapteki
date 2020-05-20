package pl.io.lekizapteki.services.test;

import java.util.List;
import org.junit.Test;
import pl.io.lekizapteki.services.ExcelParser;
import pl.io.lekizapteki.services.Medicine;

public class ExcelParserTest {

  @Test
  public void testowanko() {

    ExcelParser excelParser = new ExcelParser();

    String filePath = "src/main/resources/wykaz.xlsx";
    List<Medicine> leczki = excelParser.parseExcelFile(filePath);

    assert(leczki.size() == 4312);

    // wypisywanko lekow wczytanych
    for (Medicine medicine : leczki) {
      System.out.println(medicine.toString());
    }
  }
}
