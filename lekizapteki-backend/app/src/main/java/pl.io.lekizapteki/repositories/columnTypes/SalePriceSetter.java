package pl.io.lekizapteki.repositories.columnTypes;

import pl.io.lekizapteki.services.Medicine;

public class SalePriceSetter implements MedicinePropertySetter {
  public void setMedicineProperty(Medicine medicine, String value) {
    medicine.setSalePrice(value);
  }
}
