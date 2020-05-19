package pl.uw.mim.io.lekizapteki.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {
  List<MedicineEntity> FindMedicinesForDisease(DiseaseEntity diseaseEntity);
}
