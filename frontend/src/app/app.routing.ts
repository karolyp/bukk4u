import { NgModule } from '@angular/core';
import {Routes,RouterModule} from '@angular/router';
import {BookListComponent} from './book-list/book-list.component';
import {AuthGuardService as AuthGuard} from './_service/auth-guard.service';
import {AdminComponent} from './admin/admin.component';
import {CheckoutComponent} from './checkout/checkout.component';
import {AdminOrdersComponent} from './admin/admin-sub/admin-orders/admin-orders.component';
import {AdminBooksNewComponent} from './admin/admin-sub/admin-books-new/admin-books-new.component';
import {AdminBooksEditComponent} from './admin/admin-sub/admin-books-edit/admin-books-edit.component';
import {BookeditComponent} from './admin/admin-sub/bookedit/bookedit.component';





const mainRoutes : Routes= [
    
    {path:'booklist', component:BookListComponent},
    {path:'checkout', component:CheckoutComponent},
    {path:'admin', component: AdminComponent},
    {path:'admin/orders',component: AdminOrdersComponent},
    {path:'admin/books-new',component: AdminBooksNewComponent},
    {path:'admin/books-edit',component: AdminBooksEditComponent},
    {path:'admin/books-edit/:isbn',component:BookeditComponent},
    //these routes go last because routing uses first match wins strategy
    {path: '', redirectTo:'booklist',pathMatch:'full'},         //empty path
    {path: '**', redirectTo: 'booklist'}       //non existing path
    
];
@NgModule({
    imports:[
        RouterModule.forRoot(mainRoutes)
    ],
    exports:[
        RouterModule
    ]
})

export class mainRouting{}