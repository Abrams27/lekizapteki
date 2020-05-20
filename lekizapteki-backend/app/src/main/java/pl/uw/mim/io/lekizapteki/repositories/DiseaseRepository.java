package pl.uw.mim.io.lekizapteki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long> {

  DiseaseEntity getDiseaseEntityById(Long id);
}
