package pl.io.lekizapteki.repositories.columnTypes;

import lombok.AllArgsConstructor;
import pl.io.lekizapteki.services.Medicine;

@AllArgsConstructor
public class ChargeFactorSetter implements MedicinePropertySetter {
  public void setMedicineProperty(Medicine medicine, String value) {
    medicine.setChargeFactor(value);
  }
}
