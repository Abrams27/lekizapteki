package pl.io.lekizapteki.repositories.columnTypes;

import pl.io.lekizapteki.services.Medicine;

public class TotalRefunding implements ColumnType {
  public void setMedicineProperty(Medicine medicine, String value) {
    medicine.setTotalFunding(value);
  }
}
