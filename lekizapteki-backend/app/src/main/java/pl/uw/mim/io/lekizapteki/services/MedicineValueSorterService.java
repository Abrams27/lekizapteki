package pl.uw.mim.io.lekizapteki.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Service;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@Service
@UtilityClass
public class MedicineValueSorterService {

  public List<MedicineEntity> sort(List<MedicineEntity> medicineEntityList) {
    ArrayList<MedicineEntity> resultMedicineEntityList = new ArrayList<>(medicineEntityList);
    resultMedicineEntityList.sort(MedicineValueSorterService::compareMedicineValue);
    return resultMedicineEntityList;
  }

  private BigDecimal getDose(MedicineEntity medicineEntity) {
    return new BigDecimal(medicineEntity.getDose().getDose().split(" ")[0]);
  }

  private BigDecimal getQuantity(MedicineEntity medicineEntity) {

    return new BigDecimal(medicineEntity.getPack().getContent().split(" ")[0]);
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
