package pl.io.lekizapteki.repositories.columnTypes;

import pl.io.lekizapteki.services.Medicine;

public class NameFormDose implements ColumnType {
  public void setMedicineProperty(Medicine medicine, String value) {
    medicine.setNameAndFormAndDose(value);
  }
}
