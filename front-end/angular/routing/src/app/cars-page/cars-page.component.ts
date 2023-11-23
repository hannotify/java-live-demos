import { Component } from '@angular/core';
import { Car } from '../car';
import { CarService } from '../car-service';

@Component({
  selector: 'app-cars-page',
  templateUrl: './cars-page.component.html',
  styleUrls: ['./cars-page.component.css']
})
export class CarsPageComponent {
  cars?: Car[];
  
  constructor(private carService: CarService) {
    this.cars = carService.listCars();
  }
}
