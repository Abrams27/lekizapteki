package pl.uw.mim.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;

@Component
@AllArgsConstructor
public class GetMedicines {


  public List<MedicineDto> execute(String diseaseId) {

    return List.of(mockMedicine());
  }

  private MedicineDto mockMedicine() {
    return MedicineDto.builder()
        .ean("Mock2137")
        .dose("Ciebiera")
        .name("Krzysiu")
        .build();
  }
}
