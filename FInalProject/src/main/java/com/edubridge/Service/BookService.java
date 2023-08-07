package com.edubridge.Service;

import java.util.List;

import com.edubridge.Entity.Book;

public interface BookService {
	public Book	saveBook(Book book,int userId);
	public List<Book> getAllBook();
	public Book getBookById(int bookid);
	public void removebookById(int bookid);
	public Book updateBookById(Book book,int bookid);


}
