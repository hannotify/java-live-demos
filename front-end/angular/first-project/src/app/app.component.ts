import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  cars = [
    { make: 'Opel', model: 'Astra' },
    { make: 'Porsche', model: '911' },
  ];
}
