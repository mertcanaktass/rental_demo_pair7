package com.etiya.rentaldemopair7.repositories;


import com.etiya.rentaldemopair7.entities.concreate.CarType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarTypeRepository extends JpaRepository<CarType,Integer> {

}
