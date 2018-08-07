import { Component, OnInit } from '@angular/core';
import { UserModel } from '../models/user.model';
import { UserService } from '../user/user.service';

interface Items {
  imgIdea: string;
  price: number;
}

export const ITEMS : Items [] = [
  {imgIdea: 'un cadeau', price: 6 },
  {imgIdea: 'un cadeau', price: 10 },
  {imgIdea: 'un cadeau', price: 170 }
];

@Component({
  selector: 'app-ui',
  templateUrl: './ui.component.html',
  styleUrls: ['./ui.component.css']
})
export class UiComponent implements OnInit {

  items: Items[];
  total: number = 0;
  
  constructor() { }

  ngOnInit() {
    this.items = ITEMS;

    for(let item of ITEMS) {
        this.total = this.total + item.price;
        console.log("test");
        };
        return this.total;
  }

}
