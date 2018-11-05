import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { IdeaModel } from './idea.model';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Http, Response } from '@angular/http';

@Injectable()
export class IdeaService {

  idea: IdeaModel[] = [];
  allIdeas: IdeaModel[] = [];
  selectedIdeas: IdeaModel[] = [];
  errorMessage: String;

  private baseUrl: String = 'http://localhost:8080/';
  private prop: String = 'foo';
  public propChange: BehaviorSubject<String> = new BehaviorSubject<String>(this.prop);

  // constructor(private http: HttpClient) {
  // }

  observableItems: Observable<IdeaModel[]>

constructor(private http:Http) { 
   this.observableItems = this.http.get(this.baseUrl + "/getIdeas").map((res: Response) => res.json());
   this.observableItems.subscribe(
			 data => this.allIdeas = data,
			 error =>  this.errorMessage = <any>error);
}

getIdeas(): Observable<IdeaModel[]> {
   return this.observableItems;
} 

  public getProp() {
    return this.prop;
  }

  public setProp(prop): void {
    this.prop = prop;
    this.propChange.next(this.prop);
  }


  // public getIdeas(): Observable<IdeaModel[]> {
  //   return this.http.get<IdeaModel[]>(this.baseUrl + "getIdeas");
  // }

  addIdea(id: number): void {
    let idea = this.allIdeas.find(ob => ob.id === id);

    if (this.selectedIdeas.indexOf(idea) < 0) {
      this.selectedIdeas.push(idea);
    }

  }

  getSelectedIdea(): IdeaModel[] {
    console.log("this.selectedIdeas");
    console.log(this.selectedIdeas);
    return this.selectedIdeas;
  }

  public delete(idea: IdeaModel): Observable<any> {
    return this.http.post(this.baseUrl + "deleteIdea", JSON.stringify(idea));
  }

}
