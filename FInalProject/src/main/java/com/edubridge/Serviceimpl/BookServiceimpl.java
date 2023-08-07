package com.edubridge.Serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.Entity.Book;
import com.edubridge.Entity.User;
import com.edubridge.Repository.BookRepository;
import com.edubridge.Repository.UserRepository;
import com.edubridge.Service.BookService;
@Service
public class BookServiceimpl implements BookService{
	@Autowired
	BookRepository bookrepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Book saveBook(Book book, int userId) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).get();
		if(user.getUsertype().equalsIgnoreCase("Admin")){
			book.setUser(user);
			return bookrepository.save(book);
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<Book> getAllBook() {
		
		return bookrepository.findAll();
	}

	@Override
	public Book getBookById(int bookid) {
		return bookrepository.findById(bookid).get();
	}

	@Override
	public void removebookById(int bookid) {
		// TODO Auto-generated method stub
		Book book=getBookById(bookid);
		bookrepository.delete(book);	
	}

	@Override
	public Book updateBookById(Book book, int bookid) {
		// TODO Auto-generated method stub
		Book var=getBookById(bookid);
		var.setBookName(book.getBookName());
		var.setAuthorName(book.getAuthorName());
		var.setCategory(book.getCategory());
		var.setQuantity(book.getQuantity());
		var.setCost(book.getCost());
		var.setUser((book.getUser()));
		return bookrepository.save(var);
	}

}
