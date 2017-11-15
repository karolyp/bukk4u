import {Component} from '@angular/core';
import {CookieOptions, CookieOptionsArgs, CookieService} from "angular2-cookie/core";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user = 'User';

}
