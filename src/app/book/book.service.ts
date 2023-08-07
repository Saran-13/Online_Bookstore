import { Injectable } from '@angular/core';
import { Book } from './book.component';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseurl = "http://localhost:8089/bookstore/api/Book"; 
   
  constructor(private http: HttpClient) { }

  addbook(book: Book,userId:number) {
    return this.http.post<Book>(`${this.baseurl}/${userId}`, book);
  }
}
