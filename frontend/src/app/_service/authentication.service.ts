import {Injectable} from '@angular/core';
import {Http, URLSearchParams , RequestOptions} from '@angular/http';
import {AppConstants} from '../app.constants';
import {Observable} from 'rxjs/Observable';
import {User} from '../_model/user';

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) {
  }

  login(user: User): Observable<any> {
    let params: URLSearchParams = new URLSearchParams();
    params.set('email', user.email);
    params.set('password', user.password);

    let requestOptions = new RequestOptions({
      search : params
    });

    return this.http.get(AppConstants.API + '/user', requestOptions);

  }
}
