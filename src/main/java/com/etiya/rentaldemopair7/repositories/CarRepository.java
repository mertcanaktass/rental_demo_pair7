package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.business.dtos.responses.car.CarDetailResponse;
import com.etiya.rentaldemopair7.entities.concreate.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CarRepository extends JpaRepository<Car,Integer>{

    Car findByCarModel (String carModel);

    @Query(value="Select new com.etiya.rentaldemopair7.business.dtos.responses.car" +
            ".CarDetailResponse(c.id, c.carModel, c.dailyPrice)" +
            "from Car c WHERE c.id=:id")
    CarDetailResponse getById(int id);

    boolean existsCarByColorId(int id);

}
