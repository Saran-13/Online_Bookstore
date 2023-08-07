import { Component, OnInit } from '@angular/core';
import { Payment } from '../payment/payment.service';
import { ActivatedRoute } from '@angular/router';
import { PaymentdetailsService } from './paymentdetails.service';

@Component({
  selector: 'app-paymentdetails',
  templateUrl: './paymentdetails.component.html',
  styleUrls: ['./paymentdetails.component.css']
})
export class PaymentdetailsComponent implements OnInit{
  paymentId!: number;
  payment: Payment | null = null;

  constructor(
    private route: ActivatedRoute,
    private paymentService: PaymentdetailsService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.paymentId = +params.get('paymentId')!;
      this.getPaymentDetails();
    });
  }

  getPaymentDetails() {
    this.paymentService.getPaymentById(this.paymentId).subscribe(
      (data: Payment) => {
        this.payment = data;
      },
      error => {
        console.log('Error fetching payment details:', error);
      }
    );
  }
}
