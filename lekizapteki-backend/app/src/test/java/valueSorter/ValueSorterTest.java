package valueSorter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PackageEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;
import pl.uw.mim.io.lekizapteki.utility.MedicineValueSorter;

public class ValueSorterTest {

  @Test
  void correctMedicineSortingTest() {
    List<MedicineEntity> medicineEntityList = List
        .of(buildTestMedicineEntity(1L, "zero", "500 mg", "123", "10 szt."),
            buildTestMedicineEntity(2L, "jeden", "25 mg", "124", "15 szt."),
            buildTestMedicineEntity(3L, "dwa", "25 mg", "125", "15 szt."));
    List<MedicineEntity> resultMedicineEntityList = MedicineValueSorter.sort(medicineEntityList);

    assertEquals(1L, resultMedicineEntityList.get(0).getId());
    assertEquals(2L, resultMedicineEntityList.get(1).getId());
    assertEquals(3L, resultMedicineEntityList.get(2).getId());
  }
// todo
  private MedicineEntity buildTestMedicineEntity(Long id, String name, String dose, String ean, String content) {
    return MedicineEntity.builder()
        .id(id)
        .name(name)
//        .dose(buildTestDoseEntity(id, dose))
        .ean(ean)
        .pack(buildTestPackageEntity(id, content))
        .pricing(buildTestPricingEntity(id))
        .build();
  }

  private DoseEntity buildTestDoseEntity(Long id, String dose) {
    return DoseEntity.builder()
        .id(id)
//        .dose(dose)
        .build();
  }

  private PackageEntity buildTestPackageEntity(Long id, String content) {
    return PackageEntity.builder()
        .id(id)
//        .content(content)
        .build();
  }

  private PricingEntity buildTestPricingEntity(Long id) {
    return PricingEntity.builder()
        .id(id)
        .retailPrice(new BigDecimal("10.00"))
        .build();
  }

}
