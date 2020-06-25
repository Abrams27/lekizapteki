package pl.uw.mim.io.lekizapteki.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

  List<IngredientEntity> findAllByName(String name);

}
