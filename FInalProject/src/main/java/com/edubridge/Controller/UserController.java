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

import com.edubridge.Entity.User;
import com.edubridge.Service.UserService;

@RestController
@RequestMapping("/bookstore/api/")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		return new ResponseEntity<User>(service.registerUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping("login")
	public ResponseEntity<User> loginUser(@RequestBody User user){
		User use=service.loginUser(user);
		return new ResponseEntity<User>(use,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(User user){
		return new ResponseEntity<List<User>>(service.getalluser(user),HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		User use=service.getUserbyId(id);
		return new ResponseEntity<User>(use,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> removeUserById(@PathVariable("id") int id){
		service.removeuser(id);
		return new ResponseEntity<String>("User is removed ",HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable ("id") int id,@Valid @RequestBody User user){
		User use=service.updateuser(id, user);
		return new ResponseEntity<User> (use,HttpStatus.OK);
	}
	
}
