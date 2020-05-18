import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DiseaseSelectionProperties} from './disease-selection.properties';
import {DiseaseDto} from '../../services/webservices/models/disease/disease.dto';

@Component({
  selector: 'app-disease-dropdown-list',
  templateUrl: './disease-selection.component.html',
  styleUrls: ['./disease-selection.component.css']
})


export class DiseaseSelectionComponent implements OnInit {

  @Output()
  confirmed = new EventEmitter<void>();

  selectedDiseaseId: number;
  potwierdzonko = '';

  private diseases: DiseaseDto[] = [];
  private placeholder: string = DiseaseSelectionProperties.LIST_EMPTY_PLACEHOLDER;

  constructor() {
    this.create10kDiseases();
    this.placeholder = DiseaseSelectionProperties.LIST_PLACEHOLDER;
  }

  ngOnInit(): void { }

  getDiseases(): DiseaseDto[] {
    return this.diseases;
  }

  getPlaceholder(): string {
    return this.placeholder;
  }

  onClick() {
    if (this.selectedDiseaseId != null) {
      this.confirmed.emit();
      console.log('Tu pewnie bedzie jakas inna metoda, ale abrams kc, jakos sie udalo');
      this.potwierdzonko = 'Jakos sie udalo. Buziaczek. Id:' + this.selectedDiseaseId.toString();
    }
  }

  hidePlaceholder() {
    this.placeholder = DiseaseSelectionProperties.LIST_EMPTY_PLACEHOLDER;
    this.selectedDiseaseId = null;
  }

  private create10kDiseases() {
    this.diseases = Array.from({length: 10000}, (value, key) => key)
    .map(val => ({
      id: val,
      name: `disease ${val}`
    }));
  }

}

