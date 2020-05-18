package pl.io.lekizapteki.repositories.columnTypes;

import pl.io.lekizapteki.services.Medicine;

public class RetailPrice implements ColumnType {
  public void setMedicineProperty(Medicine medicine, String value) {
    medicine.setRetailPrice(value);
  }
}
