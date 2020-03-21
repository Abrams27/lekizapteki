package pl.io.lekizapteki.usecases;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.io.lekizapteki.models.MedicineDto;

import java.util.List;

@Component
@AllArgsConstructor
public class GetIdenticalMedicines {

    public List<MedicineDto> execute(String medicineId) {

        return List.of(mockMedicine());
    }

    private MedicineDto mockMedicine() {
        return MedicineDto.builder()
                .name("Nervosol")
                .ean("2134567890")
                .dose("12345")
                .id(12345L)
                .build();
    }

}
