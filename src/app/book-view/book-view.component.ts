import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book/book.component';
import { BookviewService } from './bookview.service';

@Component({
  selector: 'app-book',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.css']
})
export class BookViewComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookviewService, private router: Router) {}

  ngOnInit(): void {
    this.loadBooks();
    
  }

  loadBooks() {
    this.bookService.getAllBooks().subscribe(
      (books: Book[]) => {
        this.books = books;
      },
      (error) => {
        console.error('Failed to load books:', error);
      }
    );
  }

  editBook(bookId: number) {
    this.router.navigate(['/edit-book', bookId]);
  }

  removeBook(bookId: number) {
    console.log('Removing book with ID:', bookId);
  
    this.bookService.deleteBook(bookId).subscribe(
      () => {
        console.log('Book deleted successfully');
       
        this.loadBooks();
      },
      (error) => {
        console.error('Failed to delete book:', error);
        
      }
    );
  }
}
