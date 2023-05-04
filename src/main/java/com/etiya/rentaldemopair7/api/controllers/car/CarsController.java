package com.etiya.rentaldemopair7.api.controllers.car;

import com.etiya.rentaldemopair7.business.abstracts.car.CarService;
import com.etiya.rentaldemopair7.business.dtos.requests.car.AddCarRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.car.AddCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.CarDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.UpdateCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public DataResult<List<ListCarResponse>> getAll() {
        return carService.getAll();
    }

    @PostMapping("")
    public DataResult<AddCarResponse> add(@Valid @RequestBody AddCarRequest addCarRequest) {
        DataResult<AddCarResponse> response = carService.add(addCarRequest);
        return response;
    }

    @PutMapping("")
    public DataResult<UpdateCarResponse> update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.update(updateCarRequest);
    }

    @GetMapping("{id}")
    public DataResult<CarDetailResponse> getById(@PathVariable int id) {
        return carService.getById(id);
    }


}

