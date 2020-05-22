import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import {MedicineDetailsDto} from '../../services/webservices/models/medicine/detailed/medicine-details.dto';
import {IdenticalMedicinesDetailsComponentProperties} from './identical-medicines-details.properties';
import {WebService} from '../../services/webservices/web.service';
import {Observable, of} from 'rxjs';
import {IdenticalMedicinesDto} from '../../services/webservices/models/medicine/identical-medicines.dto';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-identical-medicines-details',
  templateUrl: './identical-medicines-details.component.html',
  styleUrls: ['./identical-medicines-details.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class IdenticalMedicinesDetailsComponent implements OnChanges {

  @Input()
  selectedDiseaseId: number;

  @Input()
  selectedMedicineEan: string;

  private identicalMedicines: Observable<IdenticalMedicinesDto>;
  private expandedElement: MedicineDetailsDto | null;

  private columnsToDisplay: string[] = [
    IdenticalMedicinesDetailsComponentProperties.MEDICINE_NAME_HEADER,
    IdenticalMedicinesDetailsComponentProperties.ACTIVE_INGREDIENT_HEADER,
    IdenticalMedicinesDetailsComponentProperties.RETAIL_PRICE_HEADER
  ];

  private selectedMedicine: MedicineDetailsDto = {
    ean: 'EAN 0',
    name: 'NAME 0',
    activeIngredient: 'activeIngredient 0',
    dose: 'dose 0',
    form: 'form 0',
    pricing: {
      tradePrice: 0,
      salePrice: 0,
      retailPrice: 0,
      totalFunding: 0,
      chargeFactor: 0,
      refund: 0
    }
  };

  private webService: WebService;

  constructor(webService: WebService) {
    this.webService = webService;
  }

  ngOnChanges(changes: SimpleChanges): void {
    // this.identicalMedicines = this.webService
    //   .getMedicinesForDiseaseIdenticalToGiven(this.selectedMedicineEan, this.selectedDiseaseId.toString());
    this.identicalMedicines = of({
      medicine: this.selectedMedicine,
      identicalMedicines: ELEMENT_DATA
    });
    console.log(this.selectedDiseaseId);
    console.log(this.selectedMedicineEan);

  }

  getIdenticalMedicinesDetails(): Observable<MedicineDetailsDto[]> {
    return this.identicalMedicines
      .pipe(map(identicalMedicines => identicalMedicines.identicalMedicines));
  }

  getColumnsToDisplay(): string[] {
    return this.columnsToDisplay;
  }

  getSelectedMedicine(): Observable<MedicineDetailsDto> {
    return this.identicalMedicines
      .pipe(map(identicalMedicines => identicalMedicines.medicine));
  }

  getExpandedElement(): MedicineDetailsDto | null {
    return this.expandedElement;
  }

  getColumnContentForHeader(header: string, element: MedicineDetailsDto): string | number {
    if (header === IdenticalMedicinesDetailsComponentProperties.MEDICINE_NAME_HEADER) {
      return element.name;
    }

    if (header === IdenticalMedicinesDetailsComponentProperties.ACTIVE_INGREDIENT_HEADER) {
      return element.activeIngredient;
    }

    if (header === IdenticalMedicinesDetailsComponentProperties.RETAIL_PRICE_HEADER) {
      return element.pricing.retailPrice;
    }
  }

  clickOnExpandedElement(element: MedicineDetailsDto) {
    this.expandedElement = this.expandedElement === element ? null : element;
  }

}

const ELEMENT_DATA: MedicineDetailsDto[] = [
  {
    ean: 'EAN 1',
    name: 'NAME 1',
    activeIngredient: 'activeIngredient 1',
    dose: 'dose 1',
    form: 'form 1',
    pricing: {
      tradePrice: 1,
      salePrice: 1,
      retailPrice: 1,
      totalFunding: 1,
      chargeFactor: 1,
      refund: 1
    }
  },
  {
    ean: 'EAN 2',
    name: 'NAME 2',
    activeIngredient: 'activeIngredient 2',
    dose: 'dose 2',
    form: 'form 2',
    pricing: {
      tradePrice: 2,
      salePrice: 2,
      retailPrice: 2,
      totalFunding: 2,
      chargeFactor: 2,
      refund: 2
    }
  }];
