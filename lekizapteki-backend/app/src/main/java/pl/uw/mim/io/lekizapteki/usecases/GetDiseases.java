package pl.uw.mim.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.mappers.dto.DiseasesDtoMapper;
import pl.uw.mim.io.lekizapteki.models.disease.DiseaseDto;
import pl.uw.mim.io.lekizapteki.repositories.DiseaseRepository;

@Component
@AllArgsConstructor
public class GetDiseases {
  private DiseaseRepository diseaseRepository;
  private DiseasesDtoMapper diseasesDtoMapper;

  public List<DiseaseDto> execute() {
    return diseasesDtoMapper
        .map(diseaseRepository.findAll());
  }
}
