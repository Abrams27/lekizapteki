import {Component, OnInit} from '@angular/core';
import {WebService} from '../../services/webservices/web.service';

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css'],
})
export class TopBarComponent implements OnInit {

  // TESTOWANIE
  constructor(webService: WebService) {
    const observer = {
      next: x => console.log('Observer got a next value: ' + x),
      error: err => console.log('Observer got an error: ' + err),
      complete: () => console.log('Observer got a complete notification'),
    };

    const diseases = webService
      .getDiseases()
      .subscribe(observer);
    console.log(diseases);

    const medicines = webService
      .getMedicinesForDisease('123')
      .subscribe(observer);
    console.log(medicines);

    const identicalMedicines = webService
      .getMedicinesForDiseaseIdenticalToGiven('123', '123')
      .subscribe(observer);
    console.log(identicalMedicines);
  }

  ngOnInit() {
  }

}
