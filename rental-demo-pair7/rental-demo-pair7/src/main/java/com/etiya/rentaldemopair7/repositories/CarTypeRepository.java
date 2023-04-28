package com.etiya.rentaldemopair7.repositories;


import com.etiya.rentaldemopair7.entities.concreate.CarType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarTypeRepository extends JpaRepository<CarType,Integer> {

    @Query("SELECT ct FROM CarType ct")
    List<CarType> findAllCarType();

    @Query("SELECT ct.id FROM CarType ct")
    List<Integer> findAllCarTypeId();

    @Query("SELECT ct FROM CarType ct")
    List<CarType> sortAllCarType(Sort sort);
}
