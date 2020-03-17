import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {DiseaseDto} from './models/DiseaseDto';

@Injectable({
  providedIn: 'root'
})
export class DiseasesService {

  // TODO dowiedziec sie czy do sie jakos to do pliku przeniesc
  private LEKIZAPTEKI_URL = 'TODO';

  constructor(
    private httpClient: HttpClient) {
  }

  getDiseases(): Observable<DiseaseDto[]> {
    return this.httpClient
      .get<DiseaseDto[]>(this.LEKIZAPTEKI_URL);
  }
}
