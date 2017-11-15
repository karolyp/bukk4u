import {Component, Inject, Input} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {LoginComponent} from "../login/login.component";
import {User} from "../_model/user";

@Component({
  selector: 'toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {
  cartBalance: number = 0;

  cartClicked($event): void {
    // TODO: Switch to the cart page
  }

}
