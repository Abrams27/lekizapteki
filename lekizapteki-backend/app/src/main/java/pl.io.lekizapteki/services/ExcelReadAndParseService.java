package pl.io.lekizapteki.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAndParseService {
//  private final String fileLocation = "src/main/resources/wykaz.xlsx";

  public void readAndParse(String fileLocation) throws IOException {
    FileInputStream file = new FileInputStream(new File(fileLocation));
    Workbook workbook = new XSSFWorkbook(file);

    Sheet sheet = workbook.getSheetAt(0);

    for (Row row : sheet) {
      if (row.getRowNum() < 3) { // skip pierwsze 3 wiersze bo to nagłówki
        continue;
      }
//      int i = row.getRowNum();
//      System.out.print(i + " ");

      if (validateRow(row)) {
        parseRowToEntity(row);
      }
    }
    workbook.close();
    file.close();
  }

  private boolean validateRow(Row row) {
    //TODO
    //pojedyncza substancja czynna -> zawartość komórki 'substancja czynna' nie ma w sobie znaku +
    //tylko w formie tabletek -> zawartość komórki 'nazwa, postać, dawka', jakoś sprawdzić postać
    return true;
  }

  private void parseRowToEntity(Row row) {
    //TODO nwm jak to ma działać jeszcze, gdzie co wysyłać
  }
}
