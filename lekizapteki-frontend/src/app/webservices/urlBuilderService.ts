export class UrlBuilder {
  private url;
  private params: string[];
  private constructor(origin: string) {
    this.url = origin;
    this.params = [];
  }

  static builder(origin: string): UrlBuilder {
    return new UrlBuilder(origin);
  }

  addPath(path: string): UrlBuilder {
    this.url = this.url.concat(`/${path}`);
    return this;
  }

  addParam(name: string, value: string): UrlBuilder {
    this.params.push(`${name}=${value}`);
    return this;
  }

  addParamIfDefined(name: string, value?: string): UrlBuilder {
    if (value === undefined) {
      return this;
    }
    return this.addParam(name, value);
  }

  buildUrl(): string {
    if (this.params.length > 0) {
      this.url = this.url
        .concat('?')
        .concat(this.params.join('&'));
    }
    return this.url;
  }
}
