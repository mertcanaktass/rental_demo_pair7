package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Rental;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {

}
