import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../book/book.component';

@Injectable({
  providedIn: 'root'
})
export class EditBookService {
  private baseurl = 'http://localhost:8089/bookstore/api/Book/';

  constructor(private http: HttpClient) {}

  getBookById(bookId: number): Observable<Book> {
    return this.http.get<Book>(`${this.baseurl}${bookId}`);
  }

  updateBook(book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.baseurl}${book.bookId}`, book);
  }
}
