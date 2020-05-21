package pl.uw.mim.io.lekizapteki.excel.parser.mappers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities.MedicineEntityMapper;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.repositories.MedicineRepository;

@Service
@AllArgsConstructor
public class MedicinesToEntitiesMapper {

  private final MedicineRepository medicineRepository;

  public void map(List<Medicine> medicines) {

    medicines.stream()
        .map(MedicineEntityMapper::map)
        .forEach(medicineRepository::save);
  }
}
