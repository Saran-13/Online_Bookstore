import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../register-user/register-user.component';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
    private baseUrl = "http://localhost:8089/bookstore/api/user/login";
  
    constructor(private http: HttpClient) { }
  
    public loginUser(credentials: User) {
      return this.http.post<User>(`${this.baseUrl}`, credentials);
    }

    
  } 


