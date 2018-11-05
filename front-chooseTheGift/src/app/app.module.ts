import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";
import {HttpModule} from '@angular/http';
import { FormsModule } from "@angular/forms";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';

import { RouterModule} from '@angular/router';
import { routes } from './app.routes';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UiComponent } from './ui/ui.component';
import { IdeasComponent } from './ideas/ideas.component';
import { CreateIdeaComponent } from './create-idea/create-idea.component';
import { HomeComponent } from './home/home.component';
import { ProjectComponent } from './project/project.component';
import { CreateProjectComponent } from './create-project/create-project.component';
// import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { MatTabsModule } from '@angular/material';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { CartComponent } from './cart/cart.component';
import { ItemComponent } from './item/item.component';
import { ShopComponent } from './shop/shop.component';
import { ItemService } from './item/item.service';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    CreateUserComponent,
    UiComponent,
    IdeasComponent,
    CreateIdeaComponent,
    HomeComponent,
    ProjectComponent,
    CreateProjectComponent,
    CartComponent,
    ItemComponent,
    ShopComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    MatTabsModule,
    MatDividerModule,
    MatListModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule
        // NgbModule.forRoot()
  ],
  exports: [ 
    MatTabsModule,
    MatDividerModule,
    MatListModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule
  ],
  providers: [ItemService],
  bootstrap: [AppComponent]
})
export class AppModule { }
