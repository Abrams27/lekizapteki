package pl.io.lekizapteki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.io.lekizapteki.repositories.entities.DiseaseEntity;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long> {

}
