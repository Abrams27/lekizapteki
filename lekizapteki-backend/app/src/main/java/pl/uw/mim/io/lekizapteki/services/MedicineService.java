package pl.uw.mim.io.lekizapteki.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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

  public List<MedicineEntity> getIdenticalMedicines(String ean, Long diseaseId) {

    MedicineEntity medicineEntity = getMedicineWithEanAndDiseaseId(ean, diseaseId);

    return medicineRepository
        .findAllByIngredientAndDoseAndDisease(
            medicineEntity.getIngredient(),
            medicineEntity.getDose(),
            medicineEntity.getDisease()
        );
  }

  public MedicineEntity getMedicineWithEanAndDiseaseId(String ean, Long diseaseId) {
    return medicineRepository
        .findByEanAndDisease(ean, getDiseaseWithId(diseaseId));
  }

  private DiseaseEntity getDiseaseWithId(Long diseaseId) {
    return diseaseRepository
        .getDiseaseEntityById(diseaseId)
        .orElseThrow(NoSuchDiseaseException::new);
  }
}
