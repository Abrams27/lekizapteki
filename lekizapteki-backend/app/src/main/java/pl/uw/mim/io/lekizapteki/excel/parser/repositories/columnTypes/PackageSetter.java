package pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes;

import lombok.AllArgsConstructor;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.excelDatatypes.Medicine;

@AllArgsConstructor
public class PackageSetter implements MedicinePropertySetter {

  private final Medicine medicine;

  public void setMedicineProperty(String value) {
    medicine.setPack(value);
  }
}
