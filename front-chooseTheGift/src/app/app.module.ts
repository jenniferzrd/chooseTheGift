import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";

import { RouterModule} from '@angular/router';
import { routes } from './app.routes';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UiComponent } from './ui/ui.component';
import { IdeasComponent } from './ideas/ideas.component';
import { CreateIdeaComponent } from './create-idea/create-idea.component';
import { HomeComponent } from './home/home.component';
// import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    CreateUserComponent,
    UiComponent,
    IdeasComponent,
    CreateIdeaComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    // NgbModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
