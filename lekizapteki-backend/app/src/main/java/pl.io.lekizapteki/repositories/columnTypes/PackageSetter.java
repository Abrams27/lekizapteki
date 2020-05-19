package pl.io.lekizapteki.repositories.columnTypes;

import pl.io.lekizapteki.services.Medicine;

public class PackageSetter implements MedicinePropertySetter {
  public void setMedicineProperty(Medicine medicine, String value) {
    medicine.setPack(value);
  }
}
