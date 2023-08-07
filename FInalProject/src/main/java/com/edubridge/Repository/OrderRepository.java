package com.edubridge.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.Entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer>{
}
