import {Component, ViewChild, OnInit} from '@angular/core';

import {MatDialog, MatMenuTrigger} from "@angular/material";
import {LoginWindowComponent} from "./login-window.component";
import {User} from "../_model/user";

const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  @ViewChild(MatMenuTrigger) trigger: MatMenuTrigger;

  constructor(public dialog: MatDialog) {
  }

  ngOnInit(): void {
    let savedUser = localStorage.getItem('currentUser');
    if (savedUser != null) {
      this.user = JSON.parse(savedUser);
    }

  }

  userButtonClicked($event): void {
    if (!this.user.email) {
      let dialogRef = this.dialog.open(LoginWindowComponent, {
        height: '400px',
        width: '600px',
        data: this.user
      });
    } else {
      this.trigger.openMenu();
    }
  }


}
