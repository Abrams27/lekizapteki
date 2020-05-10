import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-medicine-dropdown-list',
  templateUrl: './medicine-dropdown-list.component.html',
  styleUrls: ['./medicine-dropdown-list.component.css']
})


export class MedicineDropdownListComponent implements OnInit {

  medicines = [];
  @Input()
  dupa = '';
  selectedMedicineId: number;
  public potwierdzonko = '';
  public placeholder = '';

  constructor() {
    this.create10kMedicines();
    this.placeholder = 'Wybierz lek';
  }

  private create10kMedicines() {

    this.medicines = Array.from({length: 10000}, (value, key) => key)
    .map(val => ({
      id: val,
      name: `medicine ${val}`
    }));
  }

  ngOnInit(): void {
  }

  onClick() {
    console.log('Tu pewnie bedzie jakas inna metoda, ale abrams kc, jakos sie udalo');
    this.potwierdzonko = 'Jakos sie udalo. Buziaczek. Id:' + this.selectedMedicineId.toString();

  }
  disapearPlaceholder() {
    this.placeholder = '';
    this.selectedMedicineId = null;
  }

}

