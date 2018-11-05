import { Component, OnInit } from '@angular/core';
import { IdeaModel } from './idea.model';
import { IdeaService } from './idea.service';

@Component({
  selector: 'app-idea',
  templateUrl: './idea.component.html',
  styleUrls: ['./idea.component.css']
})
export class IdeaComponent implements OnInit {

  storeItems: IdeaModel[] = [];
  errorMessage: string;

  constructor(private ideaService: IdeaService) { }


  getStoreIdea(): void {
    this.ideaService.getIdeas().subscribe(
            data => this.storeItems = data,
            error =>  this.errorMessage = <any>error);
 }

  ngOnInit() {
    this.getStoreIdea();
  }

  addIdeaInCart(id:number): void {
    this.ideaService.addIdea(id);
  }

}
