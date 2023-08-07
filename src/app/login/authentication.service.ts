import { Injectable } from '@angular/core';
import { User } from '../register-user/register-user.component';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private loggedInUser: User | null = null;

  constructor() {}

  login(user: User) {
    this.loggedInUser = user;
  }

  getLoggedInUser(): User | null {
    return this.loggedInUser;
  }

  logout() {
    this.loggedInUser = null;
  }
}
