import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogRef, MatSnackBar} from "@angular/material";
import {FormControl, Validators} from '@angular/forms';
import {User} from "../_model/user";
import {AuthenticationService} from "../_service/authentication.service";

const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

@Component({
  selector: 'login-window',
  templateUrl: './login-window.component.html',
  styleUrls: ['./login-window.component.css']
})
export class LoginWindowComponent {

  constructor(public dialogRef: MatDialogRef<LoginWindowComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              public snackBar: MatSnackBar,
              public authenticationService: AuthenticationService) {
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

    this.authenticationService.login(this.model).subscribe(
      res => {
        let user = res.json();
        this.loading = false;
        this.openSnackBar('Belépve mint '.concat(user.fullName), 'Close'); // TODO: külön kezelni ha nem található a felhasználó
        this.data.fullName = user.fullName;
        this.dialogRef.close();
        localStorage.setItem('currentUser',JSON.stringify(user));
      },
      error => {
        this.openSnackBar('Hiba a bejelentkezés során!', 'Close');
        this.loading = false;
      }
    );

  }

}
