import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MedicineSelectionProperties} from './medicine-selection.properties';
import {MedicineDto} from '../../services/webservices/models/medicine/medicine.dto';


@Component({
  selector: 'app-medicine-selection',
  templateUrl: './medicine-selection.component.html',
  styleUrls: ['./medicine-selection.component.css']
})
export class MedicineSelectionComponent implements OnInit {
  @Input()
  ifSearchingByEan = false;

  @Output()
  confirmed = new EventEmitter<void>();

  selectedMedicineId: number;
  potwierdzonko = '';

  private medicines: MedicineDto[] = [];
  private searchTypeButtonName: string = MedicineSelectionProperties.SEARCH_TYPE_EAN_BUTTON_NAME;
  private placeholder: string = MedicineSelectionProperties.LIST_PLACEHOLDER;

  constructor() {
    this.create10kMedicines();
  }

  getSearchTypeButtonName(): string {
    return this.searchTypeButtonName;
  }

  getMedicines(): MedicineDto[] {
    return this.medicines;
  }

  getPlaceholder(): string {
    return this.placeholder;
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

  onClickSearchTypeInput(EAN: any) {
    if (this.ifSearchingByEan) {
      this.ifSearchingByEan = false;
      EAN.value = '';
    } else {
      this.ifSearchingByEan = true;
    }
  }

  openFloatingList() {
    this.placeholder = '';
    this.selectedMedicineId = null;
  }



}
