import {Component, Input, OnInit} from '@angular/core';


@Component({
  selector: 'app-medicine-dropdown-list',
  templateUrl: './medicine-dropdown-list.component.html',
  styleUrls: ['./medicine-dropdown-list.component.css']
})


export class MedicineDropdownListComponent implements OnInit {
  medicines = [];
  @Input()
  ifSearchingByEan = false;
  searchTypeButtonName = 'Szukaj po EAN';
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
    if (this.selectedMedicineId != null) {
      console.log('Tu pewnie bedzie jakas inna metoda, ale abrams kc, jakos sie udalo');
      this.potwierdzonko = 'Jakos sie udalo. Buziaczek. Id:' + this.selectedMedicineId.toString();
    }
  }

  onClickSearchType(EAN: any) {
    if (this.ifSearchingByEan) {
      this.ifSearchingByEan = false;
      this.searchTypeButtonName = 'Wybierz z listy';
      EAN.value = '';
    } else {
      this.ifSearchingByEan = true;
      this.searchTypeButtonName = 'Szukaj po EAN';
    }
  }

  disapearPlaceholder() {
    this.placeholder = '';
    this.selectedMedicineId = null;
  }

}
