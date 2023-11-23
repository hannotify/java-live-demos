import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Route, RouterModule } from '@angular/router';
import { CarsPageComponent } from './cars-page/cars-page.component';
import { CarDetailComponent } from './car-detail/car-detail.component';
import { CarService } from './car-service';
import { NavigationComponent } from './navigation/navigation.component';

const routes: Route[] = [
  { path: 'cars', component: CarsPageComponent },
  { path: 'cars/:id', component: CarDetailComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CarsPageComponent,
    CarDetailComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes)
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
