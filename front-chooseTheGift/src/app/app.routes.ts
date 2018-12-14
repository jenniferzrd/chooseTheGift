import { Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import { IdeasComponent } from './ideas/ideas.component';
import { ProjectComponent } from './project/project.component';
import { CreateIdeaComponent } from './create-idea/create-idea.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { CartComponent } from './cart/cart.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth/auth-guard.service';

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'index', component: AppComponent, canActivate: [AuthGuard] },
    { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'users', component: UserComponent, canActivate: [AuthGuard] },
    { path: 'ideas', component: IdeasComponent, canActivate: [AuthGuard] },
    { path: 'createusers', component: CreateUserComponent, canActivate: [AuthGuard] },
    { path: 'project', component: ProjectComponent, canActivate: [AuthGuard] },
    { path: 'createidea', component: CreateIdeaComponent, canActivate: [AuthGuard] },
    { path: 'createproject', component: CreateProjectComponent, canActivate: [AuthGuard] },
    { path: 'cart', component: CartComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    { path: '**', redirectTo: '/login', pathMatch: 'full'},
];