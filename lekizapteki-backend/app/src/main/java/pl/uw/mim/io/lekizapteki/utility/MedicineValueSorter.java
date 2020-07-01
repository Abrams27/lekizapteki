package pl.uw.mim.io.lekizapteki.utility;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

// TODO do przerobienia w nastepnym
@UtilityClass
public class MedicineValueSorter {

  public List<MedicineEntity> sort(List<MedicineEntity> medicineEntityList) {
    return medicineEntityList.stream()
        .sorted(MedicineValueSorter::compareMedicineValue)
        .collect(Collectors.toList());
  }

  private BigDecimal getDose(MedicineEntity medicineEntity) {
    return new BigDecimal(getDoseValue(medicineEntity));
  }

  private BigDecimal getQuantity(MedicineEntity medicineEntity) {

    return new BigDecimal(getQuantityValue(medicineEntity));
  }
//
  private String getDoseValue(MedicineEntity medicineEntity) {
    return "";
//    return medicineEntity
//        .getDose()
//        .getDose()
//        .split(" ")[0];
  }

  private String getQuantityValue(MedicineEntity medicineEntity) {
    return "";
//    return medicineEntity
//        .getPack()
//        .getContent()
//        .split(" ")[0];
  }


  private int compareMedicineValue(MedicineEntity firstMedicine, MedicineEntity secondMedicine) {
    int result = getMultiplicationResult(firstMedicine, secondMedicine);
    if (result == 0) {
      result = getCompareResult(firstMedicine, secondMedicine);
    }
    return result;
  }

  private int getCompareResult(MedicineEntity firstMedicine, MedicineEntity secondMedicine) {
    return secondMedicine.getName().compareTo(firstMedicine.getName());
  }

  private int getMultiplicationResult(MedicineEntity firstMedicine, MedicineEntity secondMedicine) {
    return getMultiplication(secondMedicine, firstMedicine).compareTo(
        getMultiplication(firstMedicine, secondMedicine));
  }

  private BigDecimal getMultiplication(MedicineEntity firstMedicine, MedicineEntity secondMedicine) {
    return getRetailPrice(secondMedicine)
        .multiply(calculateIngredientQuantity(firstMedicine));
  }

  private BigDecimal getRetailPrice(MedicineEntity secondMedicine) {
    return secondMedicine.getPricing().getRetailPrice();
  }

  private BigDecimal calculateIngredientQuantity(MedicineEntity firstMedicine) {
    return getDose(firstMedicine).multiply(getQuantity(firstMedicine));
  }

}
