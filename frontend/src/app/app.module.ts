import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatCheckboxModule, MatMenuModule, MatIconModule, MatButtonModule, MatFormFieldModule,
  MatInputModule, MatToolbarModule, MatDialogModule, MatProgressBarModule, MatSnackBarModule, MatSidenavModule,
  MatSliderModule, MatDatepickerModule, MatTabsModule
} from '@angular/material';

import {NgbModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {ToolbarComponent} from './toolbar/toolbar.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AuthenticationService} from './_service/authentication.service';
import {HttpModule} from '@angular/http';
import {SidebarComponent} from './sidebar/sidebar.component';
import 'hammerjs';
import {RegisterComponent} from './register/register.component';
import {BookListComponent} from './book-list/book-list.component';
import {BookComponent} from './book-list/book/book.component';
import {LoginWindowComponent} from "./login/login-window.component";
import {ProfileComponent} from "./login/profile/profile.component";
import {CookieService} from 'angular2-cookie/services/cookies.service';
import { mainRouting } from './app.routing';
import { CheckoutComponent } from './checkout/checkout.component';
import { AdminComponent } from './admin/admin.component';
import {AdminOrdersComponent} from './admin/admin-sub/admin-orders/admin-orders.component';
import {AdminBooksNewComponent} from './admin/admin-sub/admin-books-new/admin-books-new.component';
import {AdminBooksEditComponent} from './admin/admin-sub/admin-books-edit/admin-books-edit.component';
import { BookeditComponent } from './admin/admin-sub/bookedit/bookedit.component';







@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    LoginComponent,
    SidebarComponent,
    RegisterComponent,
    BookComponent,
    BookListComponent,
    LoginWindowComponent,
    ProfileComponent,
    CheckoutComponent,
    AdminComponent,
    AdminOrdersComponent,
    AdminBooksEditComponent,
    AdminBooksNewComponent,
    BookeditComponent
    
   
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
    MatTabsModule,
    NgbModule.forRoot(),
    NgbAlertModule.forRoot(),
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    mainRouting
  ],
  providers: [AuthenticationService, CookieService],
  bootstrap: [AppComponent],
  entryComponents: [LoginWindowComponent]
})
export class AppModule {
}
