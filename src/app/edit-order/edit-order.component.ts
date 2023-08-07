import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ViewOrderService } from '../view-order/view-order.service';
import { Book } from '../book/book.component';
import { User } from '../register-user/register-user.component';
import { Order } from '../order/order.component';
import { EditOrderService } from './edit-order.service';

@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.css']
})
export class EditOrderComponent implements OnInit {
  order: Order | undefined;
  orderId: number | undefined;
  book: Book | undefined;
  user: User | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private orderService: EditOrderService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.orderId = params['id']; 
      this.fetchOrder();
    });
  }

  fetchOrder(): void {
    if (this.orderId) {
      this.orderService.getOrderById (this.orderId).subscribe(
        (order: Order) => {
          this.order = order;
        },
        (error) => {
          console.error(error);
        }
      );
    }
  }

  updateOrder(): void {
    if (this.order && this.orderId) {
      this.orderService.updateOrder(this.order).subscribe(
        (updatedOrder: Order) => {
          console.log('Order updated successfully:', updatedOrder);
          this.router.navigate(['/vieworder']); 
        },
        (error) => {
          console.error('Error while updating order:', error);
        }
      );
    }
  }
}
