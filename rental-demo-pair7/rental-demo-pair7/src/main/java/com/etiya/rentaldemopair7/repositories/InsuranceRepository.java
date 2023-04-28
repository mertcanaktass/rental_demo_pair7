package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Insurance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
    @Query("SELECT ins FROM Insurance ins")
    List<Insurance> findAllInsurance();

    @Query("SELECT ins.id FROM Insurance ins")
    List<Integer> findAllInsuranceId();

    @Query("SELECT ins FROM Insurance ins")
    List<Insurance> sortAllInsurance(Sort sort);
}
