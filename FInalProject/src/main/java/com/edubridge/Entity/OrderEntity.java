package com.edubridge.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Orders")
public class OrderEntity {
	
	@Id
    @GeneratedValue(generator = "Order_seq")
    @SequenceGenerator(name = "Order_seq", sequenceName = "Order_seq", allocationSize = 1, initialValue =9000)
	@Column(name="OrderId")
	private int orderId;

	@NotNull(message="Quantity shoiuld be greader than 1")
	@Column(name="OrderQuantity")
	private int orderquantity;
	
	@NotNull(message="Date should not be empty")
	@Column(name="OrderDate")
	private Date date;
	
	@OneToOne(targetEntity=Book.class)
	private Book book;
	
	@OneToOne(targetEntity=User.class)
	private User user;
	

	public OrderEntity() {
		
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(int orderquantity) {
		this.orderquantity = orderquantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
