package pl.uw.mim.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.models.DiseaseDto;

@Component
@AllArgsConstructor
public class GetDiseases {

  public List<DiseaseDto> execute() {
    // TODO TO JEST MOCK
    return List.of(mockDisease());
  }

  private DiseaseDto mockDisease() {
    return DiseaseDto.builder()
        .id(2137L)
        .name("chuj")
        .build();
  }

}
