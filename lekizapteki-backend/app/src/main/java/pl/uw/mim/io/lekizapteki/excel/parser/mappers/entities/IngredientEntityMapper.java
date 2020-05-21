package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;

@UtilityClass
public class IngredientEntityMapper {

  public IngredientEntity map(String ingredient) {
    return IngredientEntity.builder()
        .name(ingredient)
        .build();
  }
}
