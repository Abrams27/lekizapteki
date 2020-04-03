export class UrlBuilder {
  private url = '';
  private params: string[] = [];
  constructor() {}

  addOrigin(origin: string): UrlBuilder {
    this.url = origin;
    this.params = [];
    return this;
  }

  addPath(path: string): UrlBuilder {
    this.url = this.url.concat(`/${path}`);
    return this;
  }

  addParam(name: string, value: string): UrlBuilder {
    if (value !== undefined) {
      this.params.push(`${name}=${value}`);
    }
    return this;
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
