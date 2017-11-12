import {Injectable} from "@angular/core";
import {Http, Headers, Response, RequestOptions} from "@angular/http";
import {User} from "../_model/user";
import {AppConstants} from "../app.constants";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";

@Injectable()
export class RegistrationService {
  constructor(private http: Http) {
  }


  register(user: User): Observable<any> {
      return this.http.post(AppConstants.API + '/user', user, this.jwt()).map((response: Response) => response.json());
  }

  private jwt() {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
      return new RequestOptions({ headers: headers });
    }
  }
}
