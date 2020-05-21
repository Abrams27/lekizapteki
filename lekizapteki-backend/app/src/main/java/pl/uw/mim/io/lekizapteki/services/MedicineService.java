package pl.uw.mim.io.lekizapteki.services;


import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.io.lekizapteki.repositories.DiseaseRepository;
import pl.uw.mim.io.lekizapteki.repositories.MedicineRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@Service
@AllArgsConstructor
public class MedicineService {
  private MedicineRepository medicineRepository;
  private DiseaseRepository diseaseRepository;
  public List<MedicineEntity> getMedicinesForDiseaseId(Long diseaseId) {
    return medicineRepository.findAllByDisease(diseaseRepository.getDiseaseEntityById(diseaseId));
  }
}
