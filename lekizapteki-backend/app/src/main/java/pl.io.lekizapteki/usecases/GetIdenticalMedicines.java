package pl.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.models.MedicineDto;

@Component
@AllArgsConstructor
public class GetIdenticalMedicines {

  public List<MedicineDto> execute(String ean, String diseaseId) {
    return List.of(mockMedicine());
  }

  private MedicineDto mockMedicine() {
    return MedicineDto.builder()
        .name("Nervosol")
        .ean("2134567890")
        .dose("12345")
        .build();
  }

}
