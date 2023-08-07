import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../register-user/register-user.component';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseurl="http://localhost:8089/bookstore/api/user/";
  getLoggedInUser: any;
  constructor(private http : HttpClient) { }

  public getAllUser(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseurl}`);
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.baseurl}`, user);
  }
  public updateUser(userId: number, user: User): Observable<User> {
    return this.http.put<User>(`${this.baseurl}${userId}`, user);
  }

  public deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseurl}${userId}`,);
  }
  
  public getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.baseurl}${userId}`);
  }

}
