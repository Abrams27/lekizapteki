package pl.io.lekizapteki.services;

import static java.util.Map.entry;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.enums.ColumnType;
import pl.io.lekizapteki.repositories.columnTypes.MedicinePropertySetter;

@Component
@AllArgsConstructor
public class ExcelParser {

  // Nie jestem pewny co do niektórych numerów kolumn, TODO do sprawdzenia
  private static final Map<Integer, ColumnType> columnIndexToColumnType = Map.ofEntries(
      entry(1, ColumnType.INGREDIENT),
      entry(2, ColumnType.NAME_FORM_DOSE),
      entry(3, ColumnType.PACKAGE),
      entry(4, ColumnType.EAN),
      entry(8, ColumnType.SALE_PRICE),
      entry(9, ColumnType.RETAIL_PRICE),
      entry(11, ColumnType.TOTAL_REFUNDING),
      entry(14, ColumnType.CHARGE_FACTOR),
      entry(15, ColumnType.REFUND)
  );

//  private FileInputStream excelFile;
//  private Workbook workbook;

  @SneakyThrows
  public List<Medicine> parseExcelFile(String filePath) {
    // Na razie przywrocilem te dwie linijki bo ciezko mi bylo zrobic zeby dzialalo bez
    FileInputStream excelFile = new FileInputStream(new File(filePath));
    Workbook workbook = new XSSFWorkbook(excelFile);

    Sheet sheet = workbook.getSheetAt(0);

    List<Medicine> medicineList = new ArrayList<>();

    for (Row row : sheet) {
      if (row.getRowNum() < 3) { // skip pierwsze 3 wiersze bo to nagłówki
        continue;
      }

      Medicine medicine = new Medicine();
      MedicinePropertySetterBuilder medicinePropertySetterBuilder = new MedicinePropertySetterBuilder(medicine);

      for (Cell cell : row) {
        int columnIndex = cell.getColumnIndex();
        if (columnIndexToColumnType.containsKey(columnIndex)) {
          String cellValue = cell.getStringCellValue();
          ColumnType columnType = columnIndexToColumnType.get(columnIndex);

          MedicinePropertySetter medicinePropertySetter = medicinePropertySetterBuilder.build(columnType);
          medicinePropertySetter.setMedicineProperty(cellValue);
        }
      }
      medicineList.add(medicine);
    }

    return medicineList;
  }
}
