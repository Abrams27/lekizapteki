import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {DiseaseDto} from './models/DiseaseDto';
import {MedicineDto} from './models/MedicineDto';

@Injectable({
  providedIn: 'root'
})
export class WebService {

  // TODO dowiedziec sie czy da sie jakos to do pliku przeniesc
  private API_URL = 'http://students.mimuw.edu.pl:2137/lekizapteki';

  constructor(private httpClient: HttpClient) {}

  // TODO na razie z plusami, nie dzialalo ${this.API_URL}
  getDiseases(): Observable<DiseaseDto[]> {
    return this.httpClient
      .get<DiseaseDto[]>(this.API_URL + '/diseases');
  }

  getMedicines(diseaseId): Observable<MedicineDto[]> {
    return this.httpClient
      .get<MedicineDto[]>(this.API_URL + '/medicines/' + diseaseId)
  }

  getIdenticalMedicines(medicineId): Observable<MedicineDto[]> {
    return this.httpClient
      .get<MedicineDto[]>(this.API_URL + '/medicines/identical/' + medicineId)
  }
}
