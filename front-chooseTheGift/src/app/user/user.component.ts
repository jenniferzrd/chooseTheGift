import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

import { UserModel } from './../models/user.model';
import { UserService } from './user.service';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [UserService]
})
export class UserComponent implements OnInit {

    private users: Array<UserModel>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.loadUsers();
    
  }

  private loadUsers(): void {
    this.userService.getUsers().subscribe(res => {
      this.users = res,
      error=> console.error(error),
      ()=> {}
});
}

public edit(user: UserModel): void {
  sessionStorage.setItem('user', JSON.stringify(user));
  this.router.navigate(['/createusers']);
}

public delete(user: UserModel): void {
  this.userService.delete(user);
  this.loadUsers();
}

}
