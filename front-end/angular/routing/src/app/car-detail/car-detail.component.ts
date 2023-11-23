import { Component } from '@angular/core';
import { Car } from '../car';
import { CarService } from '../car-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent {
  car?: Car = undefined;

  constructor(private carService: CarService, private route: ActivatedRoute) {
    route.params.subscribe(params => {
      this.car = carService.retrieveCar(params['id']);
    });
  }
}
