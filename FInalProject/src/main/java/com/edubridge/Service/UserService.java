package com.edubridge.Service;

import java.util.List;

import com.edubridge.Entity.User;

public interface UserService {
	public User registerUser(User user);
	public List<User> getalluser(User user);
	public User getUserbyId(int id);
	public User updateuser(int id,User user);
	public void removeuser(int id);
	public User loginUser(User user);
}
