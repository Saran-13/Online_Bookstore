import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book/book.component';
import { EditBookService } from './edit-book.service';

@Component({
  selector: 'app-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class editBookComponent implements OnInit {
  bookId!: number;
  book: Book = { bookId: 0, bookName: '', authorName: '', quantity: 0, category: '', cost: 0 };

  constructor(private service: EditBookService, private route: ActivatedRoute,private router: Router) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.bookId = +params['id'];
      this.loadBook();
    });
  }

  loadBook() {
    this.service.getBookById(this.bookId).subscribe(
      (book: Book) => {
        this.book = book;
      },
      (error) => {
        console.error('Failed to load book:', error);
      }
    );
  }

  updateBook() {
    this.service.updateBook(this.book).subscribe(
      (updatedBook: Book) => {
        console.log('Book updated successfully:', updatedBook);
        this.router.navigate(['/viewBook']);
      },
      (error) => {
        console.error('Failed to update book:', error);
      }
    );
  }
}
