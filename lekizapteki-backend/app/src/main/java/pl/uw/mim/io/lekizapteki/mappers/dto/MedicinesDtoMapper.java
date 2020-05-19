package pl.uw.mim.io.lekizapteki.mappers.dto;


import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@Component
@AllArgsConstructor
public class MedicinesDtoMapper {

  public List<MedicineDto> map(List<MedicineEntity> medicineEntityList) {
    return medicineEntityList.stream()
        .map(this::mapOneMedicineEntity)
        .collect(Collectors.toList());
  }
  private MedicineDto mapOneMedicineEntity(MedicineEntity medicineEntity){
    return MedicineDto.builder()
        .ean(medicineEntity.getEan())
        .dose(medicineEntity.getDose().getDose())
        .name(medicineEntity.getName())
        .build();
  }
}
