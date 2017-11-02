import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatCheckboxModule, MatMenuModule, MatIconModule, MatButtonModule, MatFormFieldModule,
  MatInputModule, MatToolbarModule, MatDialogModule, MatProgressBarModule, MatSnackBarModule, MatSidenavModule,
  MatSliderModule, MatDatepickerModule
} from '@angular/material';


import {NgbModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {ToolbarComponent} from './toolbar/toolbar.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AuthenticationService} from './_service/authentication.service';
import {HttpModule} from '@angular/http';
import { SidebarComponent } from './sidebar/sidebar.component';
import 'hammerjs';
import { RegistrationComponent } from './registration/registration.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookComponent } from './book-list/book/book.component';
import { routing } from './app.routing';
import {AuthGuardService} from './_service/auth-guard.service';



@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    LoginComponent,
    SidebarComponent,
    RegistrationComponent,
    BookComponent,
    BookListComponent,
   
  ],
  imports: [
    BrowserModule,
    MatDialogModule,
    MatSnackBarModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatButtonModule,
    MatSidenavModule,
    MatInputModule,
    MatFormFieldModule,
    MatMenuModule,
    MatProgressBarModule,
    MatToolbarModule,
    MatIconModule,
    MatSliderModule,
    MatDatepickerModule,
    NgbModule.forRoot(),
    NgbAlertModule.forRoot(),
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    routing
    
  ],
  providers: [
    AuthenticationService,
    AuthGuardService
  ],
  bootstrap: [AppComponent],
  entryComponents: [LoginComponent]
})
export class AppModule {
}
