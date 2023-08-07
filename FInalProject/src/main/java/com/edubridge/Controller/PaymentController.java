package com.edubridge.Controller;

import java.util.List;

import javax.validation.Valid;

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

import com.edubridge.Entity.Payment;
import com.edubridge.Service.PaymentService;

@RestController
@RequestMapping("/bookstore/api/payment/")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("{orderid}")
	public ResponseEntity<Payment> savePay(@Valid @RequestBody Payment pay,@PathVariable("orderid") int orderid){
		return new ResponseEntity<Payment>(paymentService.savePayment(pay, orderid),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Payment>> getAllpay(Payment pay){
		return new ResponseEntity<List<Payment>>(paymentService.getallPay(pay),HttpStatus.OK);
		
	}
	
	@GetMapping("{payid}")
	public ResponseEntity<Payment> getUserById(@PathVariable("payid") int payid){
		Payment pay=paymentService.getPayById(payid);
		return new ResponseEntity<Payment>(pay,HttpStatus.OK);
	}
	
	@DeleteMapping("{payid}")
	public ResponseEntity<String> removeUserById(@PathVariable("payid") int payid){
		paymentService.deletePay(payid);
		return new ResponseEntity<String>("Payment is removed ",HttpStatus.OK);
	}
	
	@PutMapping("{payid}")
	public ResponseEntity<Payment> updateUser(@Valid @PathVariable ("payid") int payid,@Valid @RequestBody Payment pay){
		Payment pay1=paymentService.updatepay(pay, payid);
		return new ResponseEntity<Payment> (pay1,HttpStatus.OK);
	}
	
}
