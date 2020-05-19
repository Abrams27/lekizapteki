import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MedicineSelectionProperties} from './medicine-selection.properties';
import {MedicineDto} from '../../services/webservices/models/medicine/medicine.dto';


@Component({
  selector: 'app-medicine-selection',
  templateUrl: './medicine-selection.component.html',
  styleUrls: ['./medicine-selection.component.css']
})
export class MedicineSelectionComponent implements OnInit {
  @Output()
  confirmed = new EventEmitter<void>();

  selectedMedicineId: number;
  selectedMedicineEan: string;
  potwierdzonko = '';

  private medicines: MedicineDto[] = [];
  private searchingByEan = false;
  private searchTypeButtonName: string = MedicineSelectionProperties.SEARCH_TYPE_EAN_BUTTON_NAME;
  private placeholder: string = MedicineSelectionProperties.LIST_PLACEHOLDER;

  constructor() {
    this.create10kMedicines();
  }

  isSearchingByEan(): boolean {
    return this.searchingByEan;
  }

  setSeatchingByEan() {
    this.searchingByEan = true;
  }

  setSeatchingFromList() {
    this.searchingByEan = false;
  }

  getSearchTypeButtonName(): string {
    return this.searchTypeButtonName;
  }

  getMedicines(): MedicineDto[] {
    return this.medicines;
  }

  getListPlaceholder(): string {
    return this.placeholder;
  }

  getInputPlaceholder(): string {
    return MedicineSelectionProperties.INPUT_PLACEHOLDER;
  }

  private create10kMedicines() {

    this.medicines = Array.from({length: 10000}, (value, key) => key)
    .map(val => ({
      id: val,
      name: `medicine ${val}`,
      ean: 'xd',
      dose: 'xd'
    }));
  }

  ngOnInit(): void {
  }

  onClickSubmitButton() {
    if (this.selectedMedicineId != null) {
      this.confirmed.emit();
      console.log('Tu pewnie bedzie jakas inna metoda, ale abrams kc, jakos sie udalo');
      this.potwierdzonko = 'Jakos sie udalo. Buziaczek. Id:' + this.selectedMedicineId.toString();
    }
  }

  onClickSearchTypeInput() {
    this.searchingByEan = !this.searchingByEan;
  }

  openFloatingList() {
    this.placeholder = '';
    this.selectedMedicineId = null;
  }



}
