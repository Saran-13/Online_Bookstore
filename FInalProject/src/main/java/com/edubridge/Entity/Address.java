package com.edubridge.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
	
	@NotEmpty
	@Size(min=5,message="Street Name should be not Empty")
	@Column(name="streetName",length=60)
	private String streetName;
	
	@NotEmpty
	@Size(min=5,message="City should be not Empty")
	@Column(name="city",length=60)
	private String city;
	
	@NotEmpty
	@Size(min=5,message="State should be not Empty")
	@Column(name="State",length=60)
	private String state;
	
	@NotEmpty
	@Size(min=5,message="State should be not Empty")
	@Column(name="PostalCOde",length=60)
	private int postalCode;
	
	public Address() {
		super();
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
}
