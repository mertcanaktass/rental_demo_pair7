package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Payment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query("SELECT p FROM Payment p")
    List<Payment> findAllPayment();

    @Query("SELECT p.id FROM Payment p")
    List<Integer> findAllPaymentId();

    @Query("SELECT m FROM Maintenance m")
    List<Payment> sortAllPayment(Sort sort);
}
