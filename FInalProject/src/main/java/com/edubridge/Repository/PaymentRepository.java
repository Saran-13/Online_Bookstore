package com.edubridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.Entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
