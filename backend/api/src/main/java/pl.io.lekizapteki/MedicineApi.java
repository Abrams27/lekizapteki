package pl.io.lekizapteki;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.io.lekizapteki.models.MedicineDto;

@RequestMapping("/lekizapteki")
public interface MedicineApi {


  // TODO @CrossOrigin do ugisuniecia, jedynie potrzebne do testowania lokalnie
  @CrossOrigin
  @GetMapping("/medicines/{diseaseId}")
  List<MedicineDto> getMedicines(@PathVariable String diseaseId);

  @GetMapping("/medicines/identical/{medicineId}")
  List<MedicineDto> getIdenticalMedicines(@PathVariable String medicineId);

}

