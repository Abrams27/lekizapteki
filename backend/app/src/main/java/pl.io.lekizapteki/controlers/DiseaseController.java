package pl.io.lekizapteki.controlers;

import java.util.List;
import lombok.AllArgsConstructor;
import pl.io.lekizapteki.DiseaseApi;
import pl.io.lekizapteki.models.DiseaseDto;
import pl.io.lekizapteki.usecases.GetDiseases;

@AllArgsConstructor
public class DiseaseController implements DiseaseApi {

  private GetDiseases getDiseases;

  @Override
  public List<DiseaseDto> getDiseases() {
    return getDiseases.execute();
  }
}
