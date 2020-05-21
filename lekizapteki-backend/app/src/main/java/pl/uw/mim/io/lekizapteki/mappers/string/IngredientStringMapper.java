package pl.uw.mim.io.lekizapteki.mappers.string;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;

@UtilityClass
public class IngredientStringMapper {

  public String map(IngredientEntity ingredientEntity) {
    return ingredientEntity.getName();
  }
}
