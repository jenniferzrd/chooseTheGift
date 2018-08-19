import { Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import { ProjectComponent } from './project/project.component';
import { CreateIdeaComponent } from './create-idea/create-idea.component';

export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'index', component: AppComponent },
    { path: 'home', component: HomeComponent },
    { path: 'users', component: UserComponent },
    { path: 'createusers', component: CreateUserComponent },
    { path: 'project', component: ProjectComponent },
    { path: 'createidea', component: CreateIdeaComponent }
];