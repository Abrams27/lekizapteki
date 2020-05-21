package pl.uw.mim.io.lekizapteki.mappers.dto;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@UtilityClass
public class MedicineDtoMapper {

  public MedicineDto map(MedicineEntity medicineEntity) {
    return MedicineDto.builder()
        .ean(medicineEntity.getEan())
        .dose(medicineEntity.getDose().getDose())
        .name(medicineEntity.getName())
        .build();
  }

}
