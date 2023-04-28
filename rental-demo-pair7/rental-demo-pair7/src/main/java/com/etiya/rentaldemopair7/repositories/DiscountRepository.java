package com.etiya.rentaldemopair7.repositories;


import com.etiya.rentaldemopair7.entities.concreate.Discount;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {
    @Query("SELECT d FROM Discount d")
    List<Discount> findAllDiscount();

    @Query("SELECT d.id FROM Discount d")
    List<Integer> findAllDiscountId();

    @Query("SELECT d FROM Discount d")
    List<Discount> sortAllDiscount(Sort sort);
}
