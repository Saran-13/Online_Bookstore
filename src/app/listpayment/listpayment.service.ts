import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order/order.component';

@Injectable({
  providedIn: 'root'
})
export class ListpaymentService {

  private apiUrl = 'http://localhost:8089/bookstore/api/book/order/'; 

  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.apiUrl);
  }
}
