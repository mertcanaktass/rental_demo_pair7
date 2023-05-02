package com.etiya.rentaldemopair7.repositories;


import com.etiya.rentaldemopair7.business.dtos.responses.car.CarDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse;
import com.etiya.rentaldemopair7.entities.concreate.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer>{

    Car findByCarModel (String carModel);

    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse(c.id, c.carModel, c.dailyPrice, d.id, b.id)" +
            "from Car c JOIN c.discount d JOIN c.brand b")
    List<ListCarResponse> getAll();

    @Query(value="Select new com.etiya.rentaldemopair7.business.dtos.responses.car" +
            ".CarDetailResponse(c.id, c.carModel, c.dailyPrice)" +
            "from Car c WHERE c.id=:id")
    CarDetailResponse getById(int id);

    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse(c.id, c.carModel, c.dailyPrice, d.id, b.id)" +
            "from Car c JOIN c.discount d JOIN c.brand b")
    Page<ListCarResponse> getAll(Pageable pageable);
}
