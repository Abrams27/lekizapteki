package pl.io.lekizapteki.controlers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.io.lekizapteki.DiseaseApi;
import pl.io.lekizapteki.models.DiseaseDto;
import pl.io.lekizapteki.usecases.GetDiseases;

import java.util.List;

@RestController
@AllArgsConstructor
public class DiseaseController implements DiseaseApi {

  private GetDiseases getDiseases;

  @Override
  public List<DiseaseDto> getDiseases() {
    return getDiseases.execute();
  }
}
