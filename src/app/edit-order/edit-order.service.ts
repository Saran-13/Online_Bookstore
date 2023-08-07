import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order/order.component';

@Injectable({
  providedIn: 'root'
})
export class EditOrderService {

  private baseUrl = 'http://localhost:8089/bookstore/api/book/order/';

  constructor(private http: HttpClient) { }

  getOrderById(orderId: number): Observable<Order> {
    const url = `${this.baseUrl}${orderId}`;
    return this.http.get<Order>(url);
  }

  updateOrder(order: Order): Observable<Order> {
    const url = `${this.baseUrl}${order.orderId}`;
    return this.http.put<Order>(url, order);
  }
}
