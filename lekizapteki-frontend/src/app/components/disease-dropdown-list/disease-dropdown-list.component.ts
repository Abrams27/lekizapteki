import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-disease-dropdown-list',
  templateUrl: './disease-dropdown-list.component.html',
  styleUrls: ['./disease-dropdown-list.component.css']
})


export class DiseaseDropdownListComponent implements OnInit {
  diseases = [];
  @Output()
  confirmed = new EventEmitter<void>();
  selectedDiseaseId: number;
  public potwierdzonko = '';
  public placeholder = '';

  constructor() {
    this.create10kDiseases();
    this.placeholder = 'Wybierz chorobę';
  }

  private create10kDiseases() {

    this.diseases = Array.from({length: 10000}, (value, key) => key)
    .map(val => ({
      id: val,
      name: `disease ${val}`
    }));
  }

  ngOnInit(): void {
  }

  onClick() {
    this.confirmed.emit();
    console.log('Tu pewnie bedzie jakas inna metoda, ale abrams kc, jakos sie udalo');
    this.potwierdzonko = 'Jakos sie udalo. Buziaczek. Id:' + this.selectedDiseaseId.toString();

  }
  disapearPlaceholder() {
    this.placeholder = '';
    this.selectedDiseaseId = null;
  }

}

