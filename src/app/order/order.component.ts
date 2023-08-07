import { Component, OnInit } from '@angular/core';
import { Book } from '../book/book.component';
import { OrderService } from './order.service';
import { User } from '../register-user/register-user.component';
import { BookviewService } from '../book-view/bookview.service';
import { UserService } from '../user/user.service';
import { AuthenticationService } from '../login/authentication.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  books: Book[] = [];
  orderQuantityMap: { [bookId: number]: number } = {};

  constructor(
    private bookService: BookviewService,
    private orderService: OrderService,
    private userService: UserService,
    private authenticationservice:AuthenticationService
  ) {}


  ngOnInit(): void {
    this.fetchBooks();
  }

  fetchBooks(): void {
    this.bookService.getAllBooks().subscribe(
      (books: Book[]) => {
        this.books = books;
        this.initializeOrderQuantityMap();
      },
      (error) => {
        console.error(error);
      }
    );
  }

  initializeOrderQuantityMap(): void {
    this.books.forEach((book) => {
      this.orderQuantityMap[book.bookId] = 0;
    });
  }

  placeOrder(book: Book): void {
    const orderQuantity1 = this.orderQuantityMap[book.bookId];
    console.log("My Order Quantity is "+orderQuantity1);
    if (orderQuantity1 && orderQuantity1 > 0) {
      const user = this.authenticationservice.getLoggedInUser();
      if (user) {
        const order: Order = {
          orderId:0,
          book: book,
          user: user,
          orderquantity: orderQuantity1
        };
        
        console.log("My Order is "+order)
        this.orderService.placeOrder(order).subscribe(
          (response: Book) => {
            console.log('Order placed successfully:', response);
            alert("order Placed");
            
          },
          (error) => {
            console.error('Error while placing order:', error);
          
          }
        );
      } else {
        console.error('User is not logged in.');
      }
    } else {
      console.error('Order Quantity should be a positive number.');
    }
  }
  
  
}
export interface Order {
  orderId: number; 
  book: Book;
  user: User;
  orderquantity: number;
}