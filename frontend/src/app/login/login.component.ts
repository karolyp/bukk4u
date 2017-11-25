import {Component, ViewChild, OnInit} from '@angular/core';

import {MatDialog, MatMenuTrigger} from "@angular/material";
import {LoginWindowComponent} from "./login-window.component";
import {User} from "../_model/user";
// import {CookieService} from "angular2-cookie/core";
import {AuthenticationService} from "../_service/authentication.service";

const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

  constructor(public dialog: MatDialog,
              // private _cookieService: CookieService,
               private _authService: AuthenticationService)
  {

  }

  ngOnInit() {
    // let savedUserToken = this._cookieService.get('token');
    let savedUserToken = 'asd';
    if (savedUserToken != null) {
      this._authService.getUserByToken('f4c6d2596cd74479e77b65ea7941234801f4fbe4113d5ff52b607c88eba9b20d').subscribe(res => {
        console.log(res);
      });
    }
  }


  userButtonClicked($event): void {
    if (!this.user.email) {
      let dialogRef = this.dialog.open(LoginWindowComponent, {
        height: '670px',
        width: '600px',
        data: this.user
      });
    } else {
      this.trigger.openMenu();
    }
  }


}
