export class UrlBuilder {
  private url = '';
  constructor() {}

  addOrigin(origin: string): UrlBuilder {
    this.url = origin;
    return this;
  }

  // path może być number lub string
  addPath(path): UrlBuilder {
    this.url = this.url.concat(`/${path}`);
    return this;
  }

  buildUrl(): string {
    return this.url;
  }
}
