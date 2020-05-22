package pl.uw.mim.io.lekizapteki.utility;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@UtilityClass
public class MedicineValueSorter {

  public List<MedicineEntity> sort(List<MedicineEntity> medicineEntityList) {
    return medicineEntityList.stream()
        .sorted(MedicineValueSorter::compareMedicineValue)
        .collect(Collectors.toList());
  }

  private BigDecimal getDose(MedicineEntity medicineEntity) {
    return new BigDecimal(medicineEntity
        .getDose()
        .getDose()
        .split(" ")[0]);
  }

  private BigDecimal getQuantity(MedicineEntity medicineEntity) {

    return new BigDecimal(medicineEntity
        .getPack()
        .getContent()
        .split(" ")[0]);
  }


  private int compareMedicineValue(MedicineEntity firstMedicine, MedicineEntity secondMedicine) {
    int result = getMultiplication(secondMedicine, firstMedicine).compareTo(
        getMultiplication(firstMedicine, secondMedicine));
    if (result == 0) {
      result = secondMedicine.getName().compareTo(firstMedicine.getName());
    }
    return result;
  }

  private BigDecimal getMultiplication(MedicineEntity firstMedicine, MedicineEntity secondMedicine) {
    return secondMedicine.getPricing().getRetailPrice()
        .multiply(getDose(firstMedicine).multiply(getQuantity(firstMedicine)));
  }

}
