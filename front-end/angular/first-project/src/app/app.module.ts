import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { GreetPipe } from './greet.pipe';
import { EmojifyPipe } from './emojify.pipe';

@NgModule({
  declarations: [
    AppComponent, GreetPipe, EmojifyPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
