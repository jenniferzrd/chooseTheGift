import { Component, OnInit, Input, NgModule} from '@angular/core';
// import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

interface Items {
  imgIdea: string;
  price: number;
}

export const ITEMS : Items [] = [
  {imgIdea: 'un cadeau', price: 6 },
  {imgIdea: 'un cadeau', price: 10 },
  {imgIdea: 'un cadeau', price: 170 }
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


  closeResult: string;
  items: Items[];

  constructor() { }

  ngOnInit() {
    this.items = ITEMS;
  }
}
