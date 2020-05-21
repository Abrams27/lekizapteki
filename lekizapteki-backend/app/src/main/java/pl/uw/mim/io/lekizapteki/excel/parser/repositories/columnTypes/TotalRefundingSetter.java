package pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes;

import lombok.AllArgsConstructor;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.excelDatatypes.Medicine;

@AllArgsConstructor
public class TotalRefundingSetter implements MedicinePropertySetter {

  private final Medicine medicine;

  public void setMedicineProperty(String value) {
    medicine.setTotalFunding(value);
  }
}
