import { Component, OnInit } from '@angular/core';
import { WebService } from '../../webservices/web.service';

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
    const diseases = webService.getDiseases().subscribe(observer);
    console.log(diseases);
    console.log('test');
    const medicines = webService.getMedicines('123').subscribe(observer);
    console.log(medicines);
    const identicalMedicines = webService.getIdenticalMedicines('123', '123').subscribe(observer);
    console.log(identicalMedicines);

    const allMedicines = webService.getMedicines().subscribe(observer);
    console.log(allMedicines);

    const allIdenticalMedicines = webService.getIdenticalMedicines('123').subscribe(observer);
    console.log(allIdenticalMedicines);
  }

  ngOnInit() {
  }

}
