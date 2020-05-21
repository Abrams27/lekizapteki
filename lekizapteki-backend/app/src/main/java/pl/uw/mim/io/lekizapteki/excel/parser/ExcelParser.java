package pl.uw.mim.io.lekizapteki.excel.parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.MedicinePropertySetterFactory;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.MedicinePropertySetter;
import pl.uw.mim.io.lekizapteki.excel.parser.enums.ColumnType;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;

@Component
@AllArgsConstructor
public class ExcelParser {

  private static final int FIRST_VALID_ROW = 3; // pierwsze 3 wiersze to nagłówki

  private static final Map<Integer, ColumnType> columnIndexToColumnType = Map.of(
      1, ColumnType.INGREDIENT,
      2, ColumnType.NAME_FORM_DOSE,
      3, ColumnType.PACKAGE,
      4, ColumnType.EAN,
      8, ColumnType.SALE_PRICE,
      9, ColumnType.TRADE_PRICE,
      10, ColumnType.RETAIL_PRICE,
      11, ColumnType.TOTAL_REFUNDING,
      14, ColumnType.CHARGE_FACTOR,
      15, ColumnType.REFUND
  );

  @SneakyThrows
  public List<Medicine> parseExcelFile(String filePath) {
    @Cleanup FileInputStream excelFile = new FileInputStream(new File(filePath));
    @Cleanup Workbook workbook = new XSSFWorkbook(excelFile);
    Sheet sheet = workbook.getSheetAt(0);

    return mapSheetToMedicineList(sheet);
  }

  private List<Medicine> mapSheetToMedicineList(Sheet sheet) {
    List<Medicine> medicineList = new ArrayList<>();


    for (Row row : sheet) {
      if (isMedicineRow(row)) {
        Medicine medicine = mapRowToMedicine(row);
        medicineList.add(medicine);
      }
    }

    return medicineList;
  }

  private boolean isMedicineRow(Row row) {
    return row.getRowNum() >= FIRST_VALID_ROW;
  }

  private Medicine mapRowToMedicine(Row row) {
    Medicine medicine = new Medicine();

    for (Cell cell : row) {
      int columnIndex = cell.getColumnIndex();
      if (isColumnConsidered(columnIndex)) {
        setMedicinePropertyForColumnAndCell(columnIndex, cell, medicine);
      }
    }

    return medicine;
  }

  private boolean isColumnConsidered(int columnIndex) {
    return columnIndexToColumnType.containsKey(columnIndex);
  }

  private void setMedicinePropertyForColumnAndCell(int columnIndex, Cell cell, Medicine medicine) {
    String cellValue = cell.getStringCellValue();
    ColumnType columnType = columnIndexToColumnType.get(columnIndex);

    MedicinePropertySetter medicinePropertySetter = MedicinePropertySetterFactory
        .forMedicineAndColumnType(medicine, columnType);
    medicinePropertySetter.setMedicineProperty(cellValue);
  }

}
