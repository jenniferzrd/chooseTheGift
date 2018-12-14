import { Component, OnInit } from '@angular/core';
import { UserModel } from '../models/user.model';
import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../user/user.service';
import { RouterModule, Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-ui',
  templateUrl: './ui.component.html',
  styleUrls: ['./ui.component.css'],
  providers:[UserService]
})
export class UiComponent implements OnInit {

  users: UserModel[] = [];
  total: number = 0;
  hideElement = false;

  private roles: string[];
  private authority: string;
  
  constructor(private userService: UserService, private router: Router, private tokenStorage: TokenStorageService) { 
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        if (event.url === '/login' || event.url === '/register') {
          this.hideElement = true;
        }  else {
          this.hideElement = false;
        }
      }
    });
  }

  ngOnInit() {

    this.userService.getUsers().subscribe(users => {
      this.users = users;
      this.users.forEach(user => {
        this.total = this.total + user.money;
      });
    });

    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_PM') {
          this.authority = 'pm';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }

  
}
