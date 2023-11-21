import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'template-driven-forms';
  postalCode = '';

  save(form: NgForm) {
    if (!form.valid) {
      console.error('Invalid postal code!');
    } else {
      console.log('Saving postal code:', this.postalCode);
    }
  }
}
