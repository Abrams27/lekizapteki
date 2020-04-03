import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {DiseaseDto} from './models/DiseaseDto';
import {MedicineDto} from './models/MedicineDto';
import {UrlBuilder} from './urlBuilderService';

@Injectable({
  providedIn: 'root'
})
export class WebService {

  // TODO dowiedziec sie czy da sie jakos to do pliku przeniesc
  private API_URL = 'localhost:8080/lekizapteki';
  private DISEASES_PATH = 'diesases';
  private MEDICINES_PATH = 'medicines';
  private IDENTICAL_PATH = 'identical';
  private urlBuilder = new UrlBuilder();

  constructor(private httpClient: HttpClient) {}

  getDiseases(): Observable<DiseaseDto[]> {
    return this.httpClient
    .get<DiseaseDto[]>(this.urlBuilder
      .addOrigin(this.API_URL)
      .addPath(this.DISEASES_PATH)
      .buildUrl()
    );
  }

  getMedicines(diseaseId?: string): Observable<MedicineDto[]> {
    return this.httpClient
    .get<MedicineDto[]>(this.urlBuilder
      .addOrigin(this.API_URL)
      .addPath(this.MEDICINES_PATH)
      .addParam('diseaseId', diseaseId)   // szukałem czy da się zrobić to wywołanie jedynie gdy diseaseId != undefined
      .buildUrl()                                // ale nic odpowiedniego nie znalazłem
    );
  }

  getIdenticalMedicines(ean: string, diseaseId?: string): Observable<MedicineDto[]> {
    return this.httpClient
    .get<MedicineDto[]>(this.urlBuilder
      .addOrigin(this.API_URL)
      .addPath(this.MEDICINES_PATH)
      .addPath(this.IDENTICAL_PATH)
      .addParam('ean', ean)
      .addParam('diseaseId', diseaseId)   // tu podobnie jak poprzednio, fajnie by było móc wywołać tą funkcje
      .buildUrl()                                // jedynie gdy diseaseId != undefined
    );
  }
}
