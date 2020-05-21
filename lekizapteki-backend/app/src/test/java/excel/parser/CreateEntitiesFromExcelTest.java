package excel.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.excel.parser.ExcelParser;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.excelDatatypes.Medicine;


class CreateEntitiesFromExcelTest {

  private final static String TEST_FILE_PATH = "src/main/resources/wykaz.xlsx";

  @Test
  void shouldParseAllLines() {
    ExcelParser excelParser = new ExcelParser();

    List<Medicine> medicines = excelParser.parseExcelFile(TEST_FILE_PATH);

    assertEquals(4312, medicines.size());
  }

}
