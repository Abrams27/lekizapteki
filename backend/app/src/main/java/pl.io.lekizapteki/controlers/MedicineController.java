package pl.io.lekizapteki.controlers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.io.lekizapteki.MedicineApi;
import pl.io.lekizapteki.models.MedicineDto;
import pl.io.lekizapteki.usecases.GetMedicines;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicineController implements MedicineApi {

    private GetMedicines getMedicines;

    @Override
    public List<MedicineDto> getMedicines() {
        return getMedicines.execute();
    }
}
