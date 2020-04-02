import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TopBarComponent } from './components/top-bar/top-bar.component';

import { HttpClientModule } from '@angular/common/http';
import { DropdownListComponent } from './components/dropdown-list/dropdown-list.component';
import { NgSelectModule, NgOption } from '@ng-select/ng-select';

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: '', component: TopBarComponent},
    ]),
    HttpClientModule,
    FormsModule,
    NgSelectModule,
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    DropdownListComponent,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
