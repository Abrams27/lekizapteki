import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  ifHidden = true;
  ifHidden2 = true;
  mojaFunckcjaCoPokazeKomponent() {
    this.ifHidden = false;
  }

  mojaFunckcjaCoPokazeKomponent2() {
    this.ifHidden2 = false;
  }
}

