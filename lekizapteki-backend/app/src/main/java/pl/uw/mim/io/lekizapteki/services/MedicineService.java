package pl.uw.mim.io.lekizapteki.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities.MedicineEntityMapper;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.exceptions.NoSuchDiseaseException;
import pl.uw.mim.io.lekizapteki.repositories.DiseaseRepository;
import pl.uw.mim.io.lekizapteki.repositories.MedicineRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@Service
@AllArgsConstructor
public class MedicineService {

  private MedicineRepository medicineRepository;
  private DiseaseRepository diseaseRepository;

  public List<MedicineEntity> getMedicinesForDiseaseId(Long diseaseId) {
    return medicineRepository
        .findAllByDisease(getDiseaseWithId(diseaseId));
  }

  private DiseaseEntity getDiseaseWithId(Long diseaseId) {
    return diseaseRepository
        .getDiseaseEntityById(diseaseId)
        .orElseThrow(NoSuchDiseaseException::new);
  }

  public void saveToRepository(List<Medicine> medicines) {

    medicines.stream()
        .map(MedicineEntityMapper::map)
        .forEach(medicineRepository::save);
  }

}
