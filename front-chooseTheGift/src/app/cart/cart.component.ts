import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IdeaModel } from '../models/idea.model';
import { UserModel } from '../models/user.model';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public cart = [];
  private idea: IdeaModel;
  message : String = "";

  users: UserModel[] = [];
  // ideas: IdeaModel[] = [];
  total: number= 0;
  result: number = 0;

  constructor(
    private userService: UserService,
    private router: Router) {

        if (sessionStorage.getItem("idea")) {
          this.idea = JSON.parse(sessionStorage.getItem("idea"));

          // let a = [1, 2, 3];

          let array = [];
          
          // localStorage.setItem("a", JSON.stringify(a));
          // a = JSON.parse(localStorage.getItem("a"));
          // console.log(a);
          // array = JSON.parse(sessionStorage.getItem("idea"));
          // array.push(this.idea);
          // console.log(array);
          // Re-serialize the array back into a string and store it in localStorage
          // sessionStorage.setItem('idea', JSON.stringify(array));
        }

  }

  ngOnInit() { 
    this.getResultCart();
    }

  removeCartIdea() {
    sessionStorage.removeItem("idea");
    sessionStorage.clear();
    this.router.navigate(['/ideas']);
  }

  getResultCart() {
    let resultSubUserMoneyIdeaPrice;
    let selectedIdeaPrice = this.idea.price;

    this.userService.getUsers().subscribe(users => {
      this.users = users;
      this.users.forEach(user => {
        this.total = this.total + user.money;
      });

      let totalUserMoney = this.total;
      resultSubUserMoneyIdeaPrice = totalUserMoney - selectedIdeaPrice;

      if(resultSubUserMoneyIdeaPrice <= 0 ) {
        console.log("great")
        this.message = "Vous ne disposez plus de fonds";
      } else {
        console.log("vous pouvez continuer vos achats");
        this.message = "Attention, vous avez dépassé le budget"
      }

    });
  }

}
