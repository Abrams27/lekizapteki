package pl.uw.mim.io.lekizapteki.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long> {

  Optional<DiseaseEntity> getDiseaseEntityById(Long id);

}
