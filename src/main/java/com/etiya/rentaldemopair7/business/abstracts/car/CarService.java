package com.etiya.rentaldemopair7.business.abstracts.car;


import com.etiya.rentaldemopair7.business.dtos.requests.car.AddCarRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.car.AddCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.CarDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.UpdateCarResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;

import javax.xml.crypto.Data;
import java.util.List;

public interface CarService {
    DataResult<List<ListCarResponse>> getAll();

    DataResult<AddCarResponse> add(AddCarRequest addCarRequest);

    DataResult<UpdateCarResponse> update(UpdateCarRequest updateCarRequest);

    DataResult<CarDetailResponse> getById(int id);
}
