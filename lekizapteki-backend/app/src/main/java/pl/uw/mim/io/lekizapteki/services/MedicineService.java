package pl.uw.mim.io.lekizapteki.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.io.lekizapteki.exceptions.NoSuchDiseaseException;
import pl.uw.mim.io.lekizapteki.exceptions.WrongMedicineForDiseaseException;
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
    DiseaseEntity diseaseEntity = getDiseaseWithIdOrThrow(diseaseId);

    return medicineRepository
        .findAllByDisease(diseaseEntity);
  }

  public List<MedicineEntity> getIdenticalMedicines(String ean, Long diseaseId) {
    MedicineEntity medicineEntity = getMedicineWithEanAndDiseaseIdOrThrow(ean, diseaseId);

    return medicineRepository
        .findAllByIngredientAndDoseAndDisease(
            medicineEntity.getIngredient(),
            medicineEntity.getDose(),
            medicineEntity.getDisease());
  }

  public MedicineEntity getMedicineWithEanAndDiseaseIdOrThrow(String ean, Long diseaseId) {
    DiseaseEntity diseaseEntity = getDiseaseWithIdOrThrow(diseaseId);

    return medicineRepository
        .findByEanAndDisease(ean, diseaseEntity)
        .orElseThrow(WrongMedicineForDiseaseException::new);
  }


  private DiseaseEntity getDiseaseWithIdOrThrow(Long diseaseId) {
    return diseaseRepository
        .getDiseaseEntityById(diseaseId)
        .orElseThrow(NoSuchDiseaseException::new);
  }

}
