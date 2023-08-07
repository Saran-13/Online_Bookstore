package com.edubridge.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Books")

public class Book {
	
    @Id
    @GeneratedValue(generator = "Book_seq")
    @SequenceGenerator(name = "Book_seq", sequenceName = "Book_seq", allocationSize = 1, initialValue = 7000)
    @Column(name = "BookID")
    private int bookId;
    
    @NotEmpty(message="BookName should not be Empty")
    @Size(min = 3, message = "BookName should be at least 3 characters")
    @Column(name = "BookName", length = 60)
    private String bookName;
    
    @NotEmpty(message="AuthorName should not be Empty")
    @Size(min = 3, message = "AuthorName should be at least 3 characters")
    @Column(name="AuthorName",length=60)
    private String authorName;
    
    @Min(value = 0, message = "Quantity should be a positive number or zero")
    @Column(name = "Quantity")
    private int quantity;
    
    @NotEmpty(message="Category should not be Empty")
    @Size(min = 3, message = "Category should be at least 3 characters")
    @Column(name="Category",length=60)
    private String category;
    
    @Min(value = 0, message = "Cost should be a positive number")
    @Column(name = "Cost")
    private int cost;
   
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
    
    public Book() {
    	
    }

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
