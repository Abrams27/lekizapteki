package pl.io.lekizapteki.repositories.columnTypes;

import lombok.AllArgsConstructor;
import pl.io.lekizapteki.services.Medicine;

@AllArgsConstructor
public class TotalRefundingSetter implements MedicinePropertySetter {
  private final Medicine medicine;
  public void setMedicineProperty(String value) {
    medicine.setTotalFunding(value);
  }
}
