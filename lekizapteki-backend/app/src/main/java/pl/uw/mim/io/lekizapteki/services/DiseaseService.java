package pl.uw.mim.io.lekizapteki.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.io.lekizapteki.repositories.DiseaseRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;

@Service
@AllArgsConstructor
public class DiseaseService {
  private DiseaseRepository diseaseRepository;

  public List<DiseaseEntity> getAllDiseases() {
    return diseaseRepository.findAll();
  }
}
