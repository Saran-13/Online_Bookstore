package com.edubridge.Service;

import java.util.List;

import com.edubridge.Entity.Payment;

public interface PaymentService {
	public Payment savePayment(Payment pay,int orderid);
	public List<Payment> getallPay(Payment pay);
	public Payment getPayById(int payId);
	public Payment updatepay(Payment pay,int payid) ;
	public void deletePay(int payid);
}
