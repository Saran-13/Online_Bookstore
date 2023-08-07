package com.edubridge.Entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.validation.constraints.Email;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(generator = "User_seq")
    @SequenceGenerator(name = "User_seq", sequenceName = "User_seq", allocationSize = 1, initialValue = 5000)
    @Column(name = "UserID")
    private int userId;

    @NotEmpty
    @Size(min = 3, message = "First Name should be at least 3 characters")
    @Column(name = "First_Name", length = 60)
    private String firstName;

    @NotEmpty
    @Size(min = 3, message = "Last Name should be at least 3 characters")
    @Column(name = "Last_Name", length = 60)
    private String lastName;

    @NotEmpty
    @Email(message = "Email should be in correct format")
    @Size(min = 15, max = 60, message = "Email length should be between 15 and 60")
    @Column(name = "Email", unique = true)
    private String email;

    @NotEmpty
    @Size(min = 8, max = 15, message = "Password should contain at least 8 characters")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password should contain Uppercase, Lowercase, Numbers, and special characters")
    @Column(name = "Password")
    private String password;

    @NotEmpty
    @Size(min = 10, message = "Check the Mobile number correctly")
    @Column(name = "MobileNumber", unique = true, length = 15)
    private String mobileNo;
    
    @NotEmpty(message="Type of  the user should not be empty")
    @Size(min = 5,message = "Check the Mobile number correctly")
    @Column(name="UserType",length=30)
    private String usertype;
    
    @Embedded
    private Address address;
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
    
}

