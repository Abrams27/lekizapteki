export class Logger {
  static logRequest(funcName: string, request: string) {
    const logMsg = this.logRequest.name + ': ' + funcName + ': ' + request;
    console.log(logMsg);
  }
  static logResponse(funcName: string, responce: string) {
    const logMsg = this.logResponse.name + ': ' + funcName + ': ' + responce;
    console.log(logMsg);
  }
}
