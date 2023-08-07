package com.edubridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByEmailAndPassword(String email,String password);
}
