package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.FormEntity;

@UtilityClass
public class FormEntityMapper {

  public FormEntity map(String form) {
    return FormEntity.builder()
        .name(form)
        .build();
  }
}
