import { Component, OnInit } from '@angular/core';
import { Order } from '../order/order.component';
import { Router } from '@angular/router';
import { ListpaymentService } from './listpayment.service';

@Component({
  selector: 'app-listpayment',
  templateUrl: './listpayment.component.html',
  styleUrls: ['./listpayment.component.css']
})
export class ListpaymentComponent implements OnInit {
  orders: Order[] = [];

  constructor(private orderService: ListpaymentService, private router: Router) { }

  ngOnInit() {
    this.getOrderList();
  }

  getOrderList() {
    this.orderService.getAllOrders().subscribe(
      (data: Order[]) => {
        this.orders = data;
      },
      error => {
        console.log('Error fetching orders:', error);
      }
    );
  }

  redirectToPayment(orderId: number) {
    this.router.navigate(['/payment', orderId]); 
  }
}
