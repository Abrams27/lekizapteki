import {Observable} from 'rxjs';

export class Logger {

  private static REQUEST_LOG_PREFIX = 'REQUEST';
  private static RESPONSE_LOG_PREFIX = 'RESPONSE';

  public static logRequest(functionName: string, request: string) {
    this.buildMessageAndLog(this.REQUEST_LOG_PREFIX, functionName, request);
  }

  public static logResponse<T>(functionName: string, response: Observable<T>) {
    // TODO jeszcze do poprawienia
    response.subscribe(res =>
      this.buildMessageAndLog(this.RESPONSE_LOG_PREFIX, functionName, res));
  }

  private static buildMessageAndLog(logPrefix: string, functionName: string, message: any) {
    const logMessage = `[${logPrefix}] ${functionName}: ${message}`;

    console.log(logMessage);
  }

}
