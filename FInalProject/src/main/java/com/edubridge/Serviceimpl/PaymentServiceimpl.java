package com.edubridge.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.Entity.Book;
import com.edubridge.Entity.OrderEntity;
import com.edubridge.Entity.Payment;
import com.edubridge.Repository.BookRepository;
import com.edubridge.Repository.OrderRepository;
import com.edubridge.Repository.PaymentRepository;
import com.edubridge.Service.PaymentService;
@Service
public class PaymentServiceimpl implements PaymentService{
	@Autowired
	PaymentRepository payementRepository; 
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Payment savePayment(Payment pay,int orderid) {
		OrderEntity order=orderRepository.findById(orderid).get();
		Book book=order.getBook();
		int bookamt=book.getCost();
		int orderQuan=order.getOrderquantity();
		int totalcost=0;
		for(int i=0;i<=orderQuan;i++) {
			totalcost+=bookamt;
		}
		pay.setTotalAmt(totalcost);
		pay.setOrder(order);
		return payementRepository.save(pay);
	}

	@Override
	public List<Payment> getallPay(Payment pay) {
		
		return payementRepository.findAll();
	}

	@Override
	public Payment getPayById(int payId){
		Payment pay=payementRepository.findById(payId).get();
		return pay;
	}

	@Override
	public Payment updatepay(Payment pay, int payid) {
		Payment payment=getPayById(payid);
		payment.setCardNumber(pay.getCardNumber());
		payment.setCvv(pay.getCvv());
		payment.setExpYear(pay.getExpYear());
		payment.setModeOfPayment(pay.getModeOfPayment());
		payment.setNameOnCard(pay.getNameOnCard());
		payment.setPayment_date(pay.getPayment_date());
		payment.setTotalAmt(pay.getTotalAmt());
		return payementRepository.save(payment);
	}

	@Override
	public void deletePay(int payid) {
		Payment payment=getPayById(payid);
		payementRepository.delete(payment);
	}

}
