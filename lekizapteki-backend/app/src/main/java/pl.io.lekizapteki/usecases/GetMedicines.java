package pl.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.models.MedicineDto;

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
