import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CatFact } from './CatFact';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'backend-communication';
  currentFact?: CatFact;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<CatFact>('https://catfact.ninja/fact').subscribe(fact => {
      this.currentFact = fact;
    });
  }
}
