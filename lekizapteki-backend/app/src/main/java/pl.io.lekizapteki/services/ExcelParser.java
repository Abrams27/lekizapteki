package pl.io.lekizapteki.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelParser {

  private enum ColumnType {
    INGREDIENT, NAME_FORM_DOSE, PACKAGE, EAN,
    SALE_PRICE, RETAIL_PRICE, TOTAL_REFUNDING,
    CHARGE_FACTOR, REFUND
  }

  private static final ColumnType[] columnTypesInOrder = {
      ColumnType.INGREDIENT,
      ColumnType.NAME_FORM_DOSE,
      ColumnType.PACKAGE,
      ColumnType.EAN,
      ColumnType.SALE_PRICE,
      ColumnType.RETAIL_PRICE,
      ColumnType.TOTAL_REFUNDING,
      ColumnType.CHARGE_FACTOR,
      ColumnType.REFUND
  };

  List<Medicine> parseExcelFile(String filePath) {
    try {
      FileInputStream excelFile = new FileInputStream(new File(filePath));
      Workbook workbook = new XSSFWorkbook(excelFile);

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

          switch (columnType) {
            case INGREDIENT: // kolumna 1 (Substancja Czynna)
              medicine.setIngredient(cellValue);
              break;

            case NAME_FORM_DOSE: // kolumna 2 (Nazwa, postać i dawka)
              medicine.setNameAndFormAndDose(cellValue);
              break;

            case PACKAGE: // kolumna 3 (Zawartość opakowania)
              medicine.setPack(cellValue);
              break;

            case EAN: // kolumna 4 (Kod EAN lub inny kod odpowiadający kodowi EAN)
              medicine.setEan(cellValue);
              break;

            case SALE_PRICE: // kolumna 8 (Urzędowa cena zbytu) ???
              medicine.setSalePrice(cellValue);
              break;

            case RETAIL_PRICE: // kolumna 10 (Cena detaliczna) ???
              medicine.setRetailPrice(cellValue);
              break;

            case TOTAL_REFUNDING: // kolumna 11 (Wysokość limitu finansowania) ???
              medicine.setTotalFunding(cellValue);
              break;

            case CHARGE_FACTOR: // kolumna 15 (Poziom odpłatności) ???
              medicine.setChargeFactor(cellValue);
              break;

            case REFUND: // kolumna 16 (Wysokość dopłaty świadczeniobiorcy) ???
              medicine.setRefund(cellValue);
              break;

            default:
              // tu nigdy nie bd
          }
        }
        medicineList.add(medicine);
      }
      workbook.close();
      excelFile.close();

      return medicineList;
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
