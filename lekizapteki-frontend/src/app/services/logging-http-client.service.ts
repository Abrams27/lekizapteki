import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Logger} from './log.service';

export class LoggingHttpClient {

  public static get<T>(functionName: string, httpClient: HttpClient, url: string): Observable<T> {
    Logger.logRequest(functionName, url);
    const response = httpClient.get<T>(url);
    Logger.logResponse<T>(functionName, response);

    return response;
  }

}
