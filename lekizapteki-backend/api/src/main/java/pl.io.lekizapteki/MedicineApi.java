package pl.io.lekizapteki;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.io.lekizapteki.models.MedicineDto;

@RequestMapping("/lekizapteki")
public interface MedicineApi {


  // TODO @CrossOrigin do usuniecia, jedynie potrzebne do testowania lokalnie
  @CrossOrigin
  @GetMapping("/medicines")
  List<MedicineDto> getMedicines(
      @RequestParam(required = false) String diseaseId);

  @GetMapping("/medicines/identical")
  List<MedicineDto> getIdenticalMedicines(
      @RequestParam(required = true) String ean,
      @RequestParam(required = false) String diseaseId);

}
