package com.edubridge.Service;

import java.util.List;

import com.edubridge.Entity.OrderEntity;

public interface OrderService {
	public OrderEntity saveOrder(OrderEntity order,int bookid,int userid)throws Exception;
	public List<OrderEntity> getAllOrder(OrderEntity order);
	public OrderEntity getOrderbyId(int orderid);
	public void deleteorder(int orderid);
	public OrderEntity updateOrder(OrderEntity order,int orderid);
}
