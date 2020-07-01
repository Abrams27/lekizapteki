package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;

@UtilityClass
public class DoseEntityMapper {

  public DoseEntity map(String dose) {
    return DoseEntity.builder()
        // todo
//        .dose(dose)
        .build();
  }
}
