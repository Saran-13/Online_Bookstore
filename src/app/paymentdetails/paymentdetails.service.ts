import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../payment/payment.service';

@Injectable({
  providedIn: 'root'
})
export class PaymentdetailsService {

  private apiUrl = 'http://localhost:8089/bookstore/api/payment/';

  constructor(private http: HttpClient) { }

  getPaymentById(paymentId: number): Observable<Payment> {
    const url = this.apiUrl + paymentId;
    return this.http.get<Payment>(url);
  }
}
