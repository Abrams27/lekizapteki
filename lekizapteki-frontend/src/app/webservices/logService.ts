export class Logger {
  static logRequest(funcName: string, request: string) {
    this.log(this.logRequest.name, funcName, request);
  }
  static logResponse(funcName: string, response: string) {
    this.log(this.logResponse.name, funcName, response);
  }
  private static log(logName, funcName, msg) {
    const logMsg = logName + ': ' + funcName + ': ' + msg;
    console.log(logMsg);
  }
}
