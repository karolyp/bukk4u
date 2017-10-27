import {Component} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {User} from "../_model/user";
import {AuthenticationService} from "../_service/authentication.service";
import {MatSnackBar} from "@angular/material";

const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authenticationService: AuthenticationService, public snackBar: MatSnackBar) {
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  model: User = new User();
  loading = false;

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.pattern(EMAIL_REGEX)]);

  passwordFormControl = new FormControl('', [
    Validators.required
  ]);

  login($event): void {
    this.loading = true;
    console.log(JSON.stringify(this.model));

    this.authenticationService.login(this.model).subscribe(
      res => {
        console.log(res.json());
        let user = res.json();
        this.loading = false;
        this.openSnackBar('Belépve mint '.concat(user.fullName), 'Close'); // TODO: külön kezelni ha nem található a felhasználó
      },
      error => {
        this.openSnackBar('Hiba a bejelentkezés során!', 'Close');
        this.loading = false;
      }
    );

  }

}
