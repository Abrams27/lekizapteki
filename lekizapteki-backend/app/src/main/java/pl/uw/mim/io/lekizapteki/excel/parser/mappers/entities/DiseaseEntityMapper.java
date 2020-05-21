package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;

@UtilityClass
public class DiseaseEntityMapper {

  public DiseaseEntity map(String disease) {
    return DiseaseEntity.builder()
//        .name(disease)
        .name("dupa")
        .build();
  }
}
