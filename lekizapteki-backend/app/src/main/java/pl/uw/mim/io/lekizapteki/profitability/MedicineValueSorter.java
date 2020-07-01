package pl.uw.mim.io.lekizapteki.profitability;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@Component
public class MedicineValueSorter {

  public List<MedicineEntity> sort(List<MedicineEntity> medicineEntityList) {
    return medicineEntityList.stream()
        .sorted(this::compareMedicineValue)
        .collect(Collectors.toList());
  }

  private int compareMedicineValue(MedicineEntity firstMedicine, MedicineEntity secondMedicine) {
    int result = getMultiplicationResult(firstMedicine, secondMedicine);
    if (result == 0) {
      return getCompareResult(firstMedicine, secondMedicine);
    }

    return result;
  }

}
