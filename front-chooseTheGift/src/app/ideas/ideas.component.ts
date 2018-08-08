import { Component, OnInit, Input, NgModule} from '@angular/core';
interface Items {
  imgIdea: string;
  price: number;
}

export const ITEMS : Items [] = [
  {imgIdea: '../assets/images/random_img.jpg', price: 6 },
  {imgIdea: '../assets/images/random_img.jpg', price: 12 },
  {imgIdea: '../assets/images/random_img.jpg', price: 170 }
];

@NgModule ({
  entryComponents: [ IdeasComponent]
})

@Component({
  selector: 'app-ideas',
  templateUrl: './ideas.component.html',
  styleUrls: ['./ideas.component.css']
})

export class IdeasComponent implements OnInit {

  items: Items[];

  constructor() { }

  ngOnInit() {
    this.items = ITEMS;
  }
}
