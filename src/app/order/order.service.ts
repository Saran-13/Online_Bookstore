import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../book/book.component';
import { Order } from './order.component';
import { User } from '../register-user/register-user.component';




@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseUrl = 'http://localhost:8089/bookstore/api/book/order/';
  private baseurl="http://localhost:8089/bookstore/api/Book/";

  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.baseurl}`);
  }
  
  placeOrder(order: Order) {
    const url = `${this.baseUrl}${order.book.bookId}/${order.user.userId}/${order.orderquantity}`; 

    console.log("Order Quantity in service "+order.orderquantity)

    return this.http.post<Book>(url,order);
  }
  
}