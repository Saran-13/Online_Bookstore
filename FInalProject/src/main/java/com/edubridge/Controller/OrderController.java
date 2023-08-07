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

import com.edubridge.Entity.OrderEntity;
import com.edubridge.Service.OrderService;

@RestController
@RequestMapping("/bookstore/api/book/order/")
public class OrderController {
		
		@Autowired
		OrderService  orderservice;
		@PostMapping("{bookid}/order/{userid}")
		public ResponseEntity<OrderEntity> saveOrder(@Valid @RequestBody OrderEntity order,@PathVariable("bookid") int bookid,@PathVariable("userid") int userid)throws Exception{
			return new ResponseEntity<OrderEntity>(orderservice.saveOrder(order,bookid,userid),HttpStatus.CREATED);
		}
		
		@GetMapping
		public ResponseEntity<List<OrderEntity>> getAllorder(OrderEntity order) throws Exception{
			
			return new ResponseEntity<List<OrderEntity>>(orderservice.getAllOrder(order),HttpStatus.OK);
		}
		
		@GetMapping("{orderid}")
		public ResponseEntity<OrderEntity> getorderbyId(@PathVariable("orderid") int orderid) {
			return new ResponseEntity<OrderEntity>(orderservice.getOrderbyId(orderid),HttpStatus.OK);
		}
		
		@DeleteMapping("{orderid}")
		public ResponseEntity<String> deleteOrderBy(@PathVariable("orderid") int orderid){
			orderservice.deleteorder(orderid);
			return new ResponseEntity<String>("The Order is removed",HttpStatus.OK);
		}
		
		@PutMapping("{orderid}")
		public ResponseEntity<OrderEntity> updateOrder(@PathVariable("orderid") int orderid,@RequestBody OrderEntity order){
			return new ResponseEntity<OrderEntity>(orderservice.updateOrder(order,orderid),HttpStatus.OK);
		}
		
}
