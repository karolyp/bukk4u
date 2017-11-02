import {Component, Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {LoginComponent} from "../login/login.component";

@Component({
  selector: 'toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {
  animal: string;
  name: string;
  cartBalance: number = 0;

  constructor(public dialog: MatDialog) {}

  loginClicked($event): void {
    let dialogRef = this.dialog.open(LoginComponent, {
      height: '400px',
      width: '600px',
    });
  }

  cartClicked($event): void{
    // TODO: Switch to the cart page
  }

}
