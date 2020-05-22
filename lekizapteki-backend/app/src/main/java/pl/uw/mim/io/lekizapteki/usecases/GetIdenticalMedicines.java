package pl.uw.mim.io.lekizapteki.usecases;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.mappers.dto.IdenticalMedicinesDtoMapper;
import pl.uw.mim.io.lekizapteki.mappers.dto.MedicineDetailsDtoMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.IdenticalMedicinesDto;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.MedicineDetailsDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.services.MedicineService;

@Component
@AllArgsConstructor
public class GetIdenticalMedicines {

  private MedicineService medicineService;

  public IdenticalMedicinesDto execute(String ean, Long diseaseId) {
    return IdenticalMedicinesDtoMapper.map(
        MedicineDetailsDtoMapper.map(medicineService.getMedicineWithEanAndDiseaseId(ean, diseaseId)),
            mapMedicineEntityList(medicineService.getIdenticalMedicines(ean, diseaseId))
        );
  }

  private List<MedicineDetailsDto> mapMedicineEntityList (List<MedicineEntity> medicineEntityList) {
    return medicineEntityList
        .stream()
        .map(MedicineDetailsDtoMapper::map)
        .collect(Collectors.toList());
  }

}
