import { Component, EventEmitter, Output } from '@angular/core';
import { Car } from './car';

@Component({
  selector: 'app-list-cars',
  templateUrl: './list-cars.component.html',
  styleUrls: ['./list-cars.component.css']
})
export class ListCarsComponent {
  @Output() loadingCompleted = new EventEmitter<Car[]>;
  cars?: Car[];

  constructor() {
    this.retrieveCars();
  }

  retrieveCars() {
    setTimeout(() => {
      this.cars =  [
        { make: "Peugeot", type: "306" }
      ]; // filled by backend
      this.loadingCompleted.emit(this.cars);
    }, 1000);
  }
}
