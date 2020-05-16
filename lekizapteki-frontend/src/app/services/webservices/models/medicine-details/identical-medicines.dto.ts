import {MedicineDto} from '../medicine/medicine.dto';

export interface IdenticalMedicinesDto {

  medicine: MedicineDto;
  identicalMedicines: MedicineDto[];

}
