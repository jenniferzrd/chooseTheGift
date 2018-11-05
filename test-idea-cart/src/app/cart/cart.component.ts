import { Component, OnInit } from '@angular/core';
import { IdeaService } from '../idea/idea.service';
import { IdeaModel } from '../idea/idea.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  prop : String;
  // idea: IdeaModel[] = [];
  cartIdea: IdeaModel[] = [];

  constructor(private ideaService: IdeaService) { }

  getItemsForCart(): void {
    console.log("here");
    this.cartIdea = this.ideaService.getSelectedIdea();
    console.log(this.cartIdea);
}
  
  ngOnInit() {
    this.ideaService.propChange.subscribe(prop => this.prop = prop);
    this.getItemsForCart();
  }

  changeProp() {
    this.ideaService.setProp("bar");
  }


}
