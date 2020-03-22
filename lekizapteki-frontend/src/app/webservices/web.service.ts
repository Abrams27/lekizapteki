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
  private API_URL = 'localhost:8080/lekizapteki';
  private DISEASES_PATH = '/diesases';
  private MEDICINES_PATH = '/medicines';
  private IDENTICAL_PATH = '/identical';

  private static createURL(origin : string, pathname : string, variable? : number) : string {
    let url = `${origin}/${pathname}`;

    if (variable != undefined) {
      url.concat(`/${variable}`);
    }
    return url;
  }

  constructor(private httpClient: HttpClient) {}

  getDiseases(): Observable<DiseaseDto[]> {
    return this.httpClient
    .get<DiseaseDto[]>(WebService.createURL(
      this.API_URL,
      this.DISEASES_PATH)
    );
  }

  getMedicines(diseaseId : number): Observable<MedicineDto[]> {
    return this.httpClient
      .get<MedicineDto[]>(WebService.createURL(
        this.API_URL,
        this.MEDICINES_PATH,
        diseaseId)
      );
  }

  getIdenticalMedicines(medicineId : number): Observable<MedicineDto[]> {
    return this.httpClient
      .get<MedicineDto[]>(WebService.createURL(
        this.API_URL,
        this.MEDICINES_PATH + this.IDENTICAL_PATH,
        medicineId)
      );
  }
}
