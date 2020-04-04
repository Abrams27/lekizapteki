import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DiseaseDto} from './models/DiseaseDto';
import {MedicineDto} from './models/MedicineDto';
import {UrlBuilder} from './urlBuilderService';
import {Logger} from './logService';

@Injectable({
  providedIn: 'root'
})
export class WebService {

  // TODO dowiedziec sie czy da sie jakos to do pliku przeniesc
  private API_URL = 'localhost:8080/lekizapteki';
  private DISEASES_PATH = 'diesases';
  private MEDICINES_PATH = 'medicines';
  private IDENTICAL_PATH = 'identical';

  constructor(private httpClient: HttpClient) {}

  getDiseases(): Observable<DiseaseDto[]> {
    const url = UrlBuilder.builder(this.API_URL)
      .addPath(this.DISEASES_PATH)
      .buildUrl();

    Logger.logRequest(this.getDiseases.name, url);
    return this.httpClient
      .get<DiseaseDto[]>(url);
  }

  getMedicines(diseaseId: string): Observable<MedicineDto[]> {
    const url = UrlBuilder.builder(this.API_URL)
      .addPath(this.MEDICINES_PATH)
      .addParam('diseaseId', diseaseId)
      .buildUrl();

    Logger.logRequest(this.getMedicines.name, url);
    return this.httpClient
      .get<MedicineDto[]>(url);
  }

  getIdenticalMedicines(ean: string, diseaseId: string): Observable<MedicineDto[]> {
    const url = UrlBuilder.builder(this.API_URL)
      .addPath(this.MEDICINES_PATH)
      .addPath(this.IDENTICAL_PATH)
      .addParam('ean', ean)
      .addParam('diseaseId', diseaseId)
      .buildUrl();

    Logger.logRequest(this.getIdenticalMedicines.name, url);
    return this.httpClient
      .get<MedicineDto[]>(url);
  }
}
