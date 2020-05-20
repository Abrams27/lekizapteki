package pl.io.lekizapteki.repositories.columnTypes;

import lombok.AllArgsConstructor;
import pl.io.lekizapteki.services.Medicine;

@AllArgsConstructor
public class RefundSetter implements MedicinePropertySetter {

  private final Medicine medicine;

  public void setMedicineProperty(String value) {
    medicine.setRefund(value);
  }
}
