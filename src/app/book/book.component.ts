import { Component, OnInit } from '@angular/core';
import { BookService } from './book.service';
import { User } from '../register-user/register-user.component';
import { AuthenticationService } from '../login/authentication.service';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-add-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit{
  newBook: Book = {
    bookId:0,
    bookName: '',
    authorName: '',
    quantity: 0,
    category: '',
    cost: 0,
    user: undefined 
  };
  isBookAdded: boolean = false; 
  constructor(
    private bookService: BookService,
    private authService: AuthenticationService
  ) {}
  ngOnInit(): void {
    
  }

  addBook() {
    const loggedInUser: User | null = this.authService.getLoggedInUser();
    if (loggedInUser) {
      const userId = loggedInUser.userId;

      this.bookService.addbook(this.newBook, userId).subscribe(
        (response) => {
          console.log('Book added successfully:', response)
          this.isBookAdded = true;
        },
        (error) => {
          console.error('Failed to add book:', error);
        }
      );
    } else {
      
    }
  }
}

export interface Book {
  bookId:number
  bookName: string;
  authorName: string;
  quantity: number;
  category: string;
  cost: number;
  user?: User; 
}
