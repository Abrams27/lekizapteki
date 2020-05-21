package mappers.dto;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.mappers.dto.DiseasesDtoMapper;
import pl.uw.mim.io.lekizapteki.models.disease.DiseaseDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;

public class DiseasesDtoMapperTest {

  @Test
  public void testListMapping() {
    DiseaseEntity diseaseEntity = DiseaseEntity.builder()
        .id(1L)
        .name("co ja robie ze swoim zyciem")
        .build();

    List<DiseaseEntity> diseaseEntityList = List.of(diseaseEntity);

    List<DiseaseDto> diseaseDtoList = DiseasesDtoMapper.map(diseaseEntityList);

    assert(diseaseDtoList.size() == 1);
    assert(diseaseDtoList.get(0).getId() == 1L);
    assert(diseaseDtoList.get(0).getName().equals("co ja robie ze swoim zyciem"));
  }
}
