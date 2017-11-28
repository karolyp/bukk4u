import {Injectable} from '@angular/core';
import {Http, Headers, Request, RequestOptions, RequestMethod} from '@angular/http';
import {AppConstants} from '../app.constants';
import {Observable} from 'rxjs/Observable';
import {User} from '../_model/user';

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) {
  }

  login(user: User): Observable<any> {
    let headers = new Headers({
      'Content-Type': 'application/json'
    })

    let requestOptions = new RequestOptions({
      method: RequestMethod.Post,
      headers: headers,
      url: AppConstants.API + '/user',
      body: JSON.stringify(user)
    });

    return this.http.request(new Request(requestOptions));
  }

  getUserByToken(token: string): Observable<any> {

    let params = new URLSearchParams();
    params.set('token', token);

    let requestOptions = new RequestOptions({
      method: RequestMethod.Post,
      url: AppConstants.API + '/user-token',
      search: params,
      params: params
    })

    return this.http.post(AppConstants.API + '/user-token', requestOptions);
  }
}
