package pl.uw.mim.io.lekizapteki.controlers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.uw.mim.io.lekizapteki.MedicineApi;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;
import pl.uw.mim.io.lekizapteki.usecases.GetIdenticalMedicines;
import pl.uw.mim.io.lekizapteki.usecases.GetMedicines;

@RestController
@AllArgsConstructor
public class MedicineController implements MedicineApi {

  private GetMedicines getMedicines;
  private GetIdenticalMedicines getIdenticalMedicines;

  @Override
  public List<MedicineDto> getMedicines(String diseaseId) {
    return getMedicines.execute(diseaseId);
  }

  @Override
  public List<MedicineDto> getIdenticalMedicines(String ean, String diseaseId) {
    return getIdenticalMedicines.execute(ean, diseaseId);
  }
}
