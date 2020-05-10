import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  ifHidden = true;
  mojaFunckcjaCoPokazeKomponent() {
    this.ifHidden = false;
  }

}

