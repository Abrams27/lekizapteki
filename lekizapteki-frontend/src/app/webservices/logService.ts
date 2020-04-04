export class Logger {
  static logRequest(funcName: string, request: string) {
    this.buildMessageAndLog(this.logRequest.name, funcName, request);
  }
  static logResponse(funcName: string, response: string) {
    this.buildMessageAndLog(this.logResponse.name, funcName, response);
  }
  private static buildMessageAndLog(logName, funcName, msg) {
    const logMsg = logName + ': ' + funcName + ': ' + msg;
    console.log(logMsg);
  }
}
