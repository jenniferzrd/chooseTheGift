import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from "@angular/common/http";
import { UserModel } from '../models/user.model';
import { RestResponse } from '../models/restResponse.model';

@Injectable()
export class CreateUserService {

  constructor(private http: HttpClient) { }

  public validate(user: UserModel): boolean {
    let isValid = true;

    if (!user.firstname) {
      isValid = false;
    }
    if (!user.lastname) {
      isValid = false;
    }
    if (!user.money) {
      isValid = false;
    }
    return isValid;
  }
  public saveOrUpdate(user: UserModel): Observable<RestResponse> {
    return this.http.post<RestResponse>("http://localhost:8080/saveOrUpdate", JSON.stringify(user));
}

}
