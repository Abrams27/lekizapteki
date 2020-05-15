import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DiseaseDto} from './models/DiseaseDto';
import {MedicineDto} from './models/MedicineDto';
import {UrlBuilder} from './url-builder.service';
import {LoggingHttpClient} from './logging-http-client.service';

@Injectable({
  providedIn: 'root'
})
export class WebService {

  // TODO dowiedziec sie czy da sie jakos to do pliku przeniesc
  private API_URL = 'http://students.mimuw.edu.pl:7312/lekizapteki';
  private DISEASES_PATH = 'diesases';
  private MEDICINES_PATH = 'medicines';
  private IDENTICAL_PATH = 'identical';

  public constructor(private httpClient: HttpClient) {}

  public getDiseases(): Observable<DiseaseDto[]> {
    const url = UrlBuilder.builder(this.API_URL)
      .addPath(this.DISEASES_PATH)
      .buildUrl();

    return LoggingHttpClient.get<DiseaseDto[]>(
      this.getDiseases.name,
      this.httpClient,
      url);
  }

  public getMedicinesForDisease(diseaseId: string): Observable<MedicineDto[]> {
    const url = UrlBuilder.builder(this.API_URL)
      .addPath(this.MEDICINES_PATH)
      .addParam('diseaseId', diseaseId)
      .buildUrl();

    return LoggingHttpClient.get<MedicineDto[]>(
      this.getMedicinesForDisease.name,
      this.httpClient,
      url);
  }

  public getMedicinesForDiseaseIdenticalToGiven(ean: string, diseaseId: string): Observable<MedicineDto[]> {
    const url = UrlBuilder.builder(this.API_URL)
    .addPath(this.MEDICINES_PATH)
    .addPath(this.IDENTICAL_PATH)
    .addParam('ean', ean)
    .addParam('diseaseId', diseaseId)
    .buildUrl();

    return LoggingHttpClient.get<MedicineDto[]>(
      this.getMedicinesForDiseaseIdenticalToGiven.name,
      this.httpClient,
      url);
  }
}
