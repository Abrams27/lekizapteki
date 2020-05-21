package pl.uw.mim.io.lekizapteki.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.FormEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {

  List<MedicineEntity> findAllByDisease(DiseaseEntity disease);

  MedicineEntity findByEanAndDisease(String ean, DiseaseEntity disease);

  List<MedicineEntity> findAllByIngredientAndFormAndDoseAndDisease(
      IngredientEntity ingredient,
      FormEntity form,
      DoseEntity dose,
      DiseaseEntity disease
  );
}
