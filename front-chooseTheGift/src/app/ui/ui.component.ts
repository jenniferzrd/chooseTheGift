import { Component, OnInit } from '@angular/core';
import { UserModel } from '../models/user.model';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-ui',
  templateUrl: './ui.component.html',
  styleUrls: ['./ui.component.css'],
  providers:[UserService]
})
export class UiComponent implements OnInit {

  users: UserModel[] = [];
  total: number = 0;
  
  constructor(private userService: UserService) { }

  ngOnInit() {

    this.userService.getUsers().subscribe(users => {
      this.users = users;
      this.users.forEach(user => {
        console.log(user.money);
        this.total = this.total + user.money;
        console.log(this.total);
      });
    });
  }
}
