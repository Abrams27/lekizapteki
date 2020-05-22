import {Component, EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';
import {MedicineSelectionProperties} from './medicine-selection.properties';
import {MedicineDto} from '../../services/webservices/models/medicine/medicine.dto';
import {WebService} from '../../services/webservices/web.service';
import {Observable} from 'rxjs';


@Component({
  selector: 'app-medicine-selection',
  templateUrl: './medicine-selection.component.html',
  styleUrls: ['./medicine-selection.component.css']
})
export class MedicineSelectionComponent implements OnChanges {

  @Input()
  selectedDiseaseId: number;

  @Output()
  confirmed = new EventEmitter<void>();

  selectedMedicineEan: string;

  private medicines: Observable<MedicineDto[]>;
  private searchingByEan = false;
  private webService: WebService;

  private searchTypeButtonName: string = MedicineSelectionProperties.SEARCH_TYPE_EAN_BUTTON_NAME;
  private placeholder: string = MedicineSelectionProperties.LIST_PLACEHOLDER;

  constructor(webService: WebService) {
    this.webService = webService;
  }

  ngOnChanges(changes: SimpleChanges) {
    if (this.selectedDiseaseId >= 0) {
      this.medicines = this.webService
        .getMedicinesForDisease(this.selectedDiseaseId.toString());
    }
  }

  isSearchingByEan(): boolean {
    return this.searchingByEan;
  }

  getSearchTypeButtonName(): string {
    return this.searchTypeButtonName;
  }

  getMedicines(): Observable<MedicineDto[]> {
    return this.medicines;
  }

  getListPlaceholder(): string {
    return this.placeholder;
  }

  getInputPlaceholder(): string {
    return MedicineSelectionProperties.INPUT_PLACEHOLDER;
  }


  onClickSubmitButton() {
    if (this.selectedMedicineEan != null) {
      this.confirmed.emit();
      console.log('Tu pewnie bedzie jakas inna metoda, ale abrams kc, jakos sie udalo');
      console.log(this.selectedMedicineEan);
    }
  }

  onClickSearchTypeInput() {
    this.searchingByEan = !this.searchingByEan;
  }

  openFloatingList() {
    this.placeholder = '';
  }



}
