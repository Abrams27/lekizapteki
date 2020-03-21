package pl.io.lekizapteki.controlers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.io.lekizapteki.MedicineApi;
import pl.io.lekizapteki.models.MedicineDto;
import pl.io.lekizapteki.usecases.GetIdenticalMedicines;
import pl.io.lekizapteki.usecases.GetMedicines;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicineController implements MedicineApi {

    private GetMedicines getMedicines;
    private GetIdenticalMedicines getIdenticalMedicines;

    @Override
    public List<MedicineDto> getMedicines(String diseaseId) {
        return getMedicines.execute();
    }

    @Override
    public List<MedicineDto> getIdenticalMedicines(String medicineId) {
        return getIdenticalMedicines.execute();
    }
}
