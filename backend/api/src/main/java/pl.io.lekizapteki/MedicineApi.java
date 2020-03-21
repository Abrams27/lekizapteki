package pl.io.lekizapteki;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.io.lekizapteki.models.MedicineDto;

import java.util.List;

@RequestMapping("/lekizapteki")
public interface MedicineApi {


  // TODO @CrossOrigin do usuniecia, jedynie potrzebne do testowania lokalnie
  @CrossOrigin
  @GetMapping("medicines")
  List<MedicineDto> getMedicines();

  //@GetMapp



}

