package com.edubridge.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.Entity.User;
import com.edubridge.Repository.UserRepository;
import com.edubridge.Service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;
	
	@Override
	public User registerUser(User user) {
		
			return userrepository.save(user);
	}

	@Override
	public List<User> getalluser(User user) {
	List<User> list=userrepository.findAll();
		return list;
	}

	@Override
	public User getUserbyId(int id) {
		User use=userrepository.findById(id).get();
		return use;
	}

	@Override
	public User updateuser(int id, User user) {
		User use=getUserbyId(id);
		use.setFirstName(user.getFirstName());
		use.setLastName(user.getLastName());
		use.setEmail(user.getEmail());
		use.setMobileNo(user.getMobileNo());
		use.setPassword(user.getPassword());
		use.setAddress(user.getAddress());
		use.setUsertype(user.getUsertype());	
		return userrepository.save(use);
	}

	@Override
	public void removeuser(int id) {
		User user=getUserbyId(id);
		userrepository.delete(user);	
	}

	@Override
	public User loginUser(User user) {
		User use=userrepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return use;
	}
}
