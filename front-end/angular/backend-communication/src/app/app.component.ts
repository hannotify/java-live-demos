import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CatFact } from './CatFact';
import { Greeting } from './Greeting';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'backend-communication';
  currentFact?: CatFact;
  hello?: Greeting;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<CatFact>('https://catfact.ninja/fact').subscribe(fact => {
      this.currentFact = fact;
    });

    this.http.get<Greeting>('http://localhost:9080/movies/api/hello').subscribe(greeting => {
      this.hello = greeting;
    });

    this.http.post<Greeting>('http://localhost:9080/movies/api/hello', {}).subscribe(greeting => {
      console.log('POST request succeeded');
    });
  }
}
