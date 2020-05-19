package pl.io.lekizapteki.repositories.columnTypes;

import pl.io.lekizapteki.services.Medicine;

public class NameFormDoseSetter implements MedicinePropertySetter {
  public void setMedicineProperty(Medicine medicine, String value) {
    medicine.setNameAndFormAndDose(value);
  }
}
