package mappers.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.mappers.dto.DiseasesDtoMapper;
import pl.uw.mim.io.lekizapteki.models.disease.DiseaseDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;

class DiseasesDtoMapperTest {

  private final static Long DISEASE_ID = 1L;
  private final static String DISEASE_NAME = "test name";

  @Test
  void shouldMapEntityDoDto() {
    DiseaseEntity diseaseEntity = buildTestDiseaseEntity();

    List<DiseaseDto> diseaseDtoList = DiseasesDtoMapper.map(List.of(diseaseEntity));

    assertEquals(1, diseaseDtoList.size());
    assertEquals(DISEASE_ID, diseaseDtoList.get(0).getId());
    assertEquals(DISEASE_NAME, diseaseDtoList.get(0).getName());
  }

  private DiseaseEntity buildTestDiseaseEntity() {
    return DiseaseEntity.builder()
        .id(DISEASE_ID)
        .name(DISEASE_NAME)
        .build();
  }

}
