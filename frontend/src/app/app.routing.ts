import {Routes,RouterModule} from "@angular/router";
import {BookListComponent} from "./book-list/book-list.component";
import {AuthGuardService as AuthGuard} from "./_service/auth-guard.service";


const routes : Routes= [
    {path: '', redirectTo:'booklist',pathMatch:'full'},
    {path:'booklist', component:BookListComponent,canActivate:[AuthGuard]}
];

export const routing = RouterModule.forRoot(routes);