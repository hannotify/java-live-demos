import { Injectable } from "@angular/core";
import { Car } from "./car";

@Injectable()
export class CarService {
    cars: Car[] = [
        { id: 1, make: "VW", type: "Golf", hp: 170 },
        { id: 2, make: "Peugeot", type: "306", hp: 145 },
        { id: 3, make: "Kia", type: "Niro EV", hp: 215 },
        { id: 4, make: "Audi", type: "A1", hp: 270 },
    ]

    listCars(): Car[] {
        return this.cars;
    }

    retrieveCar(id: number) {
        return this.cars[id - 1];
    }
}