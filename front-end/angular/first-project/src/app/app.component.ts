import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  recipient: string = 'Jesper'
  imageLocation: string = '/assets/img/angular.svg'
  isHidden: boolean = false

  cars = [
    { make: 'Opel', model: 'Astra', price: 7500 },
    { make: 'Porsche', model: '911', price: 35000 },
    { make: 'Mazda', model: '<strong>MX5</strong>', price: 25000 }
  ];

  printToConsole() {
    console.log('Hello from the console!');
  }

  toggleHidden() {
    this.isHidden = !this.isHidden;
  }
}
