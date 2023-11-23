import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoadingComponent } from './loading/loading.component';
import { ListCarsComponent } from './list-cars/list-cars.component';

@NgModule({
  declarations: [
    AppComponent,
    LoadingComponent,
    ListCarsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
