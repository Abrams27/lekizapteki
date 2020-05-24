package pl.uw.mim.io.lekizapteki.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;

public interface DoseRepository extends JpaRepository<DoseEntity, Long> {

  List<DoseEntity> findAllByDose(String dose);
}
