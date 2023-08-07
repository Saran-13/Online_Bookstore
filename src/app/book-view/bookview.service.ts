import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../book/book.component';


@Injectable({
  providedIn: 'root'
})
export class BookviewService {
  private baseurl = "http://localhost:8089/bookstore/api/Book/";

  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.baseurl}`);
  }
  
  deleteBook(bookId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseurl}`+bookId);
  }
  
}
