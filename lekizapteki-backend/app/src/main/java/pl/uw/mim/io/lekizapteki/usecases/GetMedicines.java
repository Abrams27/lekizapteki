package pl.uw.mim.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.mappers.dto.MedicinesDtoMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;
import pl.uw.mim.io.lekizapteki.repositories.DiseaseRepository;
import pl.uw.mim.io.lekizapteki.repositories.MedicineRepository;

@Component
@AllArgsConstructor
public class GetMedicines {

  private DiseaseRepository diseaseRepository;
  private MedicineRepository medicineRepository;
  private MedicinesDtoMapper medicinesDtoMapper;

  public List<MedicineDto> execute(Long diseaseId) {
    return medicinesDtoMapper
        .map(medicineRepository.FindMedicinesForDisease(diseaseRepository.getDiseaseEntityById(diseaseId)));
  }


  private MedicineDto mockMedicine() {
    return MedicineDto.builder()
        .ean("Mock2137")
        .dose("Ciebiera")
        .name("Krzysiu")
        .build();
  }
}
