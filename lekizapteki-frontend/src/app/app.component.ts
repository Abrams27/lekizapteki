import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {

  isMedicineSelectionHidden = true;
  areIdenticalMedicinesHidden = true;

  selectedDiseaseId: number;

  constructor() {
    this.selectedDiseaseId = -1;
  }

  confirmedDiseaseSelection($event) {
    this.isMedicineSelectionHidden = false;
    this.selectedDiseaseId = $event;
  }

  mojaFunckcjaCoPokazeKomponent2() {
    this.areIdenticalMedicinesHidden = false;
  }
}

