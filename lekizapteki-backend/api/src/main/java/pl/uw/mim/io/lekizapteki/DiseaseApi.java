package pl.uw.mim.io.lekizapteki;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.uw.mim.io.lekizapteki.models.DiseaseDto;

@RequestMapping("/lekizapteki")
public interface DiseaseApi {

  // TODO @CrossOrigin do usuniecia, jedynie potrzebne do testowania lokalnie
  @CrossOrigin(origins = "*")
  @GetMapping("/diseases")
  List<DiseaseDto> getDiseases();

}
