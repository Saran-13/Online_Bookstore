package com.edubridge.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.Entity.Book;
import com.edubridge.Entity.OrderEntity;
import com.edubridge.Entity.User;
import com.edubridge.Exception.ResourceNotFoundException;
import com.edubridge.Repository.BookRepository;
import com.edubridge.Repository.OrderRepository;
import com.edubridge.Repository.UserRepository;
import com.edubridge.Service.OrderService;

@Service
public class OrderServiceimpl implements OrderService{
	
	@Autowired
	OrderRepository orderrepository;
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	BookRepository bookrepository;

	@Override
	public OrderEntity saveOrder(OrderEntity order,int bookid,int userid) throws ResourceNotFoundException {
		
		try{
			User user1=userrepository.findById(userid).get();
			Book book1=bookrepository.findById(bookid).get();
			int bookQuanity=book1.getQuantity();
			int orderquan=order.getOrderquantity();
			int res=bookQuanity-orderquan;
			if(res<=0) {
				throw new ResourceNotFoundException("BookQuantity is less than the orderQuantity");
			}
			book1.setQuantity(res);
			bookrepository.save(book1);
			order.setUser(user1);
			order.setBook(book1);
		}
		catch(Exception ex){
			throw new ResourceNotFoundException("user or Book is not present");
		}
	
		return orderrepository.save(order);
	}

	@Override
	public List<OrderEntity> getAllOrder(OrderEntity order) {
		
		return orderrepository.findAll();
	}

	@Override
	public OrderEntity getOrderbyId(int orderid) {
		OrderEntity order=orderrepository.findById(orderid).get();
		return order;
	}

	@Override
	public void deleteorder(int orderid) {
		OrderEntity order=orderrepository.findById(orderid).get();
		orderrepository.delete(order);
	}

	@Override
	public OrderEntity updateOrder(OrderEntity order, int orderid) {
		OrderEntity order1=orderrepository.findById(orderid).get();
		order1.setBook(order.getBook());
		order1.setDate(order.getDate());
		order1.setOrderquantity(order.getOrderquantity());
		order1.setUser(order.getUser());
		return orderrepository.save(order1);
	}

}
