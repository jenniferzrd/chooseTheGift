import { Component, OnInit, Input, NgModule } from '@angular/core';
import { Router } from "@angular/router";

import { IdeaModel } from './../models/idea.model';
import { IdeasService } from './ideas.service';

/// DONNEES MOCK ///

interface Items {
  imgIdea: string;
  price: number;
}

export const ITEMS: Items[] = [
  { imgIdea: '../assets/images/random_img.jpg', price: 6 },
  { imgIdea: '../assets/images/random_img.jpg', price: 12 },
  { imgIdea: '../assets/images/random_img.jpg', price: 170 },
  { imgIdea: '../assets/images/random_img.jpg', price: 170 }
];

@Component({
  selector: 'app-ideas',
  templateUrl: './ideas.component.html',
  styleUrls: ['./ideas.component.css'],
  providers: [IdeasService]
})

export class IdeasComponent implements OnInit {

  private ideas: Array<IdeaModel>;
  private idea: IdeaModel;

  wasClicked = false;
  idee = false;

  // MOCK
  items: Items[];

  constructor(
    private ideasService: IdeasService, private router: Router
  ) { }

  ngOnInit() {
    // MOCK
    this.items = ITEMS;
    this.loadIdeas();
  }

  loadIdeas() {
    this.ideasService.getIdeas().subscribe(res => {
      this.ideas = res;
    })
  };

  edit(idea: IdeaModel) {
    sessionStorage.setItem('idea', JSON.stringify(idea));
    this.router.navigate(['/createidea']);
  }

  delete(idea: IdeaModel) {
    this.ideasService.delete(idea).subscribe(data => {
      this.ideas = data;
      this.loadIdeas();
    })
  }

  like(e, idee, idea: IdeaModel) {
    this.wasClicked = !this.wasClicked;
    if (this.wasClicked) {
      e.jaime = true;
      idee.target.style.color = '#f53b57';
    } else {
      e.jaime = false;
      idee.target.style.color = '#fab1a0';
    }
  }

  selected(idea: IdeaModel) {
    // sessionStorage.setItem("idea", JSON.stringify(idea));
    // this.router.navigate(['/cart']);
    let array = [];
    let test = [];
    let i;

    sessionStorage.setItem('array', JSON.stringify(idea));
    array = JSON.parse(sessionStorage.getItem("array"));
    // console.log(sessionStorage.array);
    test.push(JSON.parse(sessionStorage.getItem("array")));
    // console.log(test);

    // for(i=0; i < test.length; i++) {
    //   console.log(test[i]);
    // }
 
  }
}
