package pl.uw.mim.io.lekizapteki.usecases;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.mappers.dto.MedicinesDtoMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.MedicineDto;
import pl.uw.mim.io.lekizapteki.services.MedicineService;

@Component
@AllArgsConstructor
public class GetMedicines {

  MedicineService medicineService;

  public List<MedicineDto> execute(Long diseaseId) {
    return MedicinesDtoMapper
        .map(medicineService.getMedicinesForDiseaseId(diseaseId));
  }
}
