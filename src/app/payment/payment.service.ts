import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = 'http://localhost:8089/bookstore/api/payment/'; 

  constructor(private http: HttpClient) { }

  savePayment(payment: Payment, orderId: number): Observable<Payment> {
    const url = this.apiUrl + orderId;
    return this.http.post<Payment>(url, payment);
  }
  
  getPaymentById(paymentId: number): Observable<Payment> {
    const url = this.apiUrl + paymentId;
    return this.http.get<Payment>(url);
  }
}
export interface Payment {
  paymentId: number;
  totalAmt: number;
  nameOnCard: string;
  cardNumber: string;
  expYear: string;
  cvv: number;
}