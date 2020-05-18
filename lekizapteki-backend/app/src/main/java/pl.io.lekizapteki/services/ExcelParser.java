package pl.io.lekizapteki.services;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.repositories.columnTypes.ChargeFactor;
import pl.io.lekizapteki.repositories.columnTypes.ColumnType;
import pl.io.lekizapteki.repositories.columnTypes.Ean;
import pl.io.lekizapteki.repositories.columnTypes.Ingredient;
import pl.io.lekizapteki.repositories.columnTypes.NameFormDose;
import pl.io.lekizapteki.repositories.columnTypes.Package;
import pl.io.lekizapteki.repositories.columnTypes.Refund;
import pl.io.lekizapteki.repositories.columnTypes.RetailPrice;
import pl.io.lekizapteki.repositories.columnTypes.SalePrice;
import pl.io.lekizapteki.repositories.columnTypes.TotalRefunding;

@Component
@AllArgsConstructor
public class ExcelParser {

  private static final ColumnType[] columnTypesInOrder = {
      new Ingredient(),
      new NameFormDose(),
      new Package(),
      new Ean(),
      new SalePrice(),
      new RetailPrice(),
      new TotalRefunding(),
      new ChargeFactor(),
      new Refund()
  };

  private FileInputStream excelFile;
  private Workbook workbook;

  @SneakyThrows
  public List<Medicine> parseExcelFile(String filePath) {
//    FileInputStream excelFile = new FileInputStream(new File(filePath));
//    Workbook workbook = new XSSFWorkbook(excelFile);

    Sheet sheet = workbook.getSheetAt(0);

    List<Medicine> medicineList = new ArrayList<>();
    for (Row row : sheet) {
      if (row.getRowNum() < 3) { // skip pierwsze 3 wiersze bo to nagłówki
        continue;
      }

      Medicine medicine = new Medicine();

      for (Cell cell : row) {
        int columnIndex = cell.getColumnIndex();
        String cellValue = cell.getStringCellValue();

        ColumnType columnType = columnTypesInOrder[columnIndex];
        columnType.setMedicineProperty(medicine, cellValue);
      }
      medicineList.add(medicine);
    }

    return medicineList;
  }
}
