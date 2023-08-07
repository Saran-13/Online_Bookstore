package com.edubridge.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Payments")
public class Payment {
	@Id
	@GeneratedValue(generator = "Payment_seq")
    @SequenceGenerator(name = "Payment_seq", sequenceName = "Payment_seq", allocationSize = 1, initialValue =3000)
	@Column(name="PaymentId")
	private int paymentid;
	
	@NotEmpty(message="Mode of Payment Should be empty")
	@Size(min=3,message="Mode of payment should be either offline or online Payment")
	@Column(name="Paymentmode")
	private String modeOfPayment;
	
	@NotNull
	@Min(value=0,message="totalamt should be positive")
	@Column(name="totalamt")
	private int totalAmt;
	
	@NotNull(message="PaymentDate should not be empty")
	@Column(name="Payment_date")
	private Date payment_date;
	
	@Column(name="name_on_card")
	@NotEmpty
	@Size(min=3 , message="name must contain atleast 3 characters")
	private String nameOnCard;

	@Column(name="card_number")
	@NotEmpty
	@Size(min=16 , max=16,message="cardNumber must contain 16 digits")
	private String cardNumber;

	@Column(name="exp_year")
	private String expYear;

	@Column(name="cvv")
	@NotNull
	private int cvv;

	@OneToOne(targetEntity=OrderEntity.class)
	@PrimaryKeyJoinColumn(name="orderId")
	private OrderEntity order;

	public Payment() {
		super();
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public int getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

		
}
