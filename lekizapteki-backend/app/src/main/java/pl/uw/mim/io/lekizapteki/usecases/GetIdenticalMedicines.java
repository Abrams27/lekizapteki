package pl.uw.mim.io.lekizapteki.usecases;

import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.mappers.dto.MedicineDetailsDtoMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.IdenticalMedicinesDto;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.MedicineDetailsDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.services.MedicineService;

@Component
@AllArgsConstructor
public class GetIdenticalMedicines {

  private MedicineService medicineService;

  private MedicineDetailsDto MapMedicineDetails(MedicineEntity medicineEntity) {
    return MedicineDetailsDtoMapper.map(medicineEntity);
  }

  public IdenticalMedicinesDto execute(String ean, Long diseaseId) {
    return IdenticalMedicinesDto.builder()
        .medicine(MapMedicineDetails(medicineService.getMedicineWithEanAndDiseaseId(ean, diseaseId)))
        .identicalMedicines(
            medicineService.getIdenticalMedicines(ean, diseaseId)
            .stream()
            .map(MedicineDetailsDtoMapper::map)
            .collect(Collectors.toList())
        )
        .build();
  }
}
