import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatCheckboxModule, MatMenuModule, MatIconModule, MatButtonModule, MatFormFieldModule,
  MatInputModule, MatToolbarModule, MatDialogModule, MatProgressBarModule, MatSnackBarModule
} from '@angular/material';

import {NgbModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {ToolbarComponent} from './toolbar/toolbar.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AuthenticationService} from "./_service/authentication.service";
import {HttpModule} from "@angular/http";
import { SidebarComponent } from './sidebar/sidebar.component';

const appRoutes: Routes = [];

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    LoginComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    MatDialogModule,
    MatSnackBarModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatMenuModule,
    MatProgressBarModule,
    MatToolbarModule,
    MatIconModule,
    NgbModule.forRoot(),
    NgbAlertModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule,
    FormsModule,
    HttpModule
  ],
  providers: [AuthenticationService],
  bootstrap: [AppComponent],
  entryComponents: [LoginComponent]
})
export class AppModule {
}
