package pl.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.models.MedicineDto;

@Component
@AllArgsConstructor
public class GetMedicines {


  public List<MedicineDto> execute(String medicineId) {

    return List.of(mockMedicine());
  }

  private MedicineDto mockMedicine() {
    return MedicineDto.builder()
        .id(2137L)
        .ean("Mock2137")
        .dose("Ciebiera")
        .name("Krzysiu")
        .build();
  }
}
