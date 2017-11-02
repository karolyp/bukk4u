import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

@Injectable()
export class AuthGuardService implements CanActivate {

  constructor(public router: Router) {}

  canActivate(): boolean {
    if (localStorage.getItem('email') === null) {
      console.log('Acces denied.');
      return false;
    }
    console.log('Acces granted.');
    return true;
  }

}