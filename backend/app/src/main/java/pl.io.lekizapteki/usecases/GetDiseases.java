package pl.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import pl.io.lekizapteki.models.DiseaseDto;

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
