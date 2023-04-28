package com.etiya.rentaldemopair7.business.abstracts.car;

import com.etiya.rentaldemopair7.business.dtos.requests.car.AddCarRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.car.AddCarResponse;

public interface CarService {
    AddCarResponse add(AddCarRequest addCarRequest);

}
