package pl.io.lekizapteki.repositories.columnTypes;

import pl.io.lekizapteki.services.Medicine;

public interface MedicinePropertySetter {
  void setMedicineProperty(Medicine medicine, String value);
}
