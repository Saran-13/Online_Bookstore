package com.edubridge.Controller;

import java.util.List;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.Entity.Book;
import com.edubridge.Service.BookService;


@RestController
@RequestMapping("/bookstore/api/Book/")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("{userId}")
	public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book ,@PathVariable("userId") int userId){		
			return new ResponseEntity<Book>(bookService.saveBook(book,userId),HttpStatus.CREATED);	
	}
	
	@GetMapping
	public List<Book> getAllBook(){
		return bookService.getAllBook();
		
	}
	
	@GetMapping("{bookid}")
	public ResponseEntity<Book> getBookbyId(@Valid @PathVariable("bookid") int bookId){
		return new ResponseEntity<Book>(bookService.getBookById(bookId),HttpStatus.OK);
	}
	
	@DeleteMapping("{bookid}")
	public ResponseEntity<String> removeBookById(@Valid @PathVariable("bookid") int bookid){
		bookService.removebookById(bookid);
		
		return new ResponseEntity<String>(("Book is Deleted "),HttpStatus.OK);	
	}
	
	@PutMapping("{bookid}")
	public ResponseEntity<Book> updatebyid(@Valid @PathVariable("bookid") int bookid,@RequestBody Book book ){
		return new ResponseEntity<Book>(bookService.updateBookById(book,bookid),HttpStatus.OK);
	}


}
