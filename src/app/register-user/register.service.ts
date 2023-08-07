import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './register-user.component';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private baseurl="http://localhost:8089/bookstore/api/user/";
  constructor(private http:HttpClient) { }

  public registerUser(user: User) {
    return this.http.post<User>(`${this.baseurl}`, user);
  }
}
