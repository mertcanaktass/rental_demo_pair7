package com.etiya.rentaldemopair7.business.concretes.car;

import com.etiya.rentaldemopair7.business.abstracts.car.CarService;
import com.etiya.rentaldemopair7.business.dtos.requests.car.AddCarRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.car.AddCarResponse;
import com.etiya.rentaldemopair7.entities.concreate.Car;
import com.etiya.rentaldemopair7.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;

    @Override
    public AddCarResponse add(AddCarRequest addCarRequest) {

        return null;
    }
}
