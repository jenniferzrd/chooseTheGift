import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";
import { HttpModule, } from '@angular/http';

import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import { IdeaComponent } from './idea/idea.component';
import { IdeaService } from './idea/idea.service';


@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    IdeaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [IdeaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
