import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Logger} from './logService';

export class HttpClientWrapper {
  static get<T>(funcName: string, httpClient: HttpClient, url: string): Observable<T> {
    Logger.logRequest(funcName, url);
    const response = httpClient.get<T>(url);
    Logger.logResponse<T>(funcName, response);
    return response;
  }
}
