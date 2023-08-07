package com.edubridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.Entity.Book;
import com.edubridge.Entity.User;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	
}
