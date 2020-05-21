package mappers.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.mappers.dto.MedicinesDtoMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

class MedicinesDtoMapperTest {

  private final static Long DOSE_ID = 1L;
  private final static String DOSE_DOSE = "test dose";

  private final static Long MEDICINE_ID = 2L;
  private final static String MEDICINE_NAME = "test medicine";
  private final static String MEDICINE_EAN = "test ean";

  @Test
  void shouldMapEntityToDto() {
    MedicineEntity medicineEntity = buildTestMedicineEntity();

    List<MedicineDto> medicineDtoList = MedicinesDtoMapper.map( List.of(medicineEntity));

    assertEquals(1, medicineDtoList.size());
    assertEquals(DOSE_DOSE, medicineDtoList.get(0).getDose());
    assertEquals(MEDICINE_NAME, medicineDtoList.get(0).getName());
    assertEquals(MEDICINE_EAN, medicineDtoList.get(0).getEan());
  }

  private MedicineEntity buildTestMedicineEntity() {
    return MedicineEntity.builder()
        .id(MEDICINE_ID)
        .name(MEDICINE_NAME)
        .dose(buildTestDoseEntity())
        .ean(MEDICINE_EAN)
        .build();
  }

  private DoseEntity buildTestDoseEntity() {
    return DoseEntity.builder()
        .id(DOSE_ID)
        .dose(DOSE_DOSE)
        .build();
  }

}
