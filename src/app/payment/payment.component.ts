import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Payment, PaymentService } from './payment.service';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  orderId!: number;
  paymentId!: number;
  payment: Payment = {} as Payment;

  constructor(
    private route: ActivatedRoute,
    private paymentService: PaymentService
  ) { }


  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.orderId = +params.get('orderId')!;
    });
  }

  savePayment() {
    if (this.orderId !== null) {
      this.paymentService.savePayment(this.payment, this.orderId).subscribe(
        (data: Payment) => {
          console.log('Payment saved successfully:', data);
          alert("Payment Successfull")
        },
        error => {
          console.log('Error saving payment:', error);
        }
      );
    } else {
      console.log('Order ID is null. Cannot save payment.');
    }
  }
  

}
