import java.util.List;
import org.junit.Test;
import pl.uw.mim.io.lekizapteki.mappers.dto.MedicinesDtoMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

public class MedicinesDtoMapperTest {

  @Test
  public void testListMapping() {
    DoseEntity doseEntity = DoseEntity.builder()
        .id(1L)
        .dose("co ja robie ze swoim zyciem")
        .build();
    MedicineEntity medicineEntity = MedicineEntity.builder()
        .id(2L)
        .name("Nie jest latwo")
        .dose(doseEntity)
        .ean("KC Marcin nawet jak jestes zly")
        .build();
    List<MedicineEntity> medicineEntityList = List.of(medicineEntity);
    List<MedicineDto> medicineDtoList = MedicinesDtoMapper.map(medicineEntityList);
    assert (medicineDtoList.size() == 1);
    assert (medicineDtoList.get(0).getDose().equals("co ja robie ze swoim zyciem"));
    assert (medicineDtoList.get(0).getName().equals("Nie jest latwo"));
    assert (medicineDtoList.get(0).getEan().equals("KC Marcin nawet jak jestes zly"));
  }
}
