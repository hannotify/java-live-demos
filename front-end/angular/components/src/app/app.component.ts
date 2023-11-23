import { Component, ViewChild } from '@angular/core';
import { Car } from './list-cars/car';
import { ListCarsComponent } from './list-cars/list-cars.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild(ListCarsComponent)
  listCars!: ListCarsComponent;
  loadingCompleted = false;
  title = 'components';

  notifyLoadingCompleted() {
    this.loadingCompleted = true;
  }
}
