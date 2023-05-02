package com.etiya.rentaldemopair7.api.controllers.color;

import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.AddColorRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.UpdateColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.UpdateBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.AddCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.CarDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.AddColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ColorDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.UpdateColorResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

    @Autowired
    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    private ColorService colorService;

    @GetMapping("")
    public DataResult<List<ListColorResponse>> getAll() {
        return colorService.getAll();
    }

    @PostMapping("")
    public DataResult<AddColorResponse> add(@Valid @RequestBody AddColorRequest addColorRequest) {
        DataResult<AddColorResponse> response = colorService.add(addColorRequest);
        return response;
    }

    @PutMapping("")
    public DataResult<UpdateColorResponse> update(@Valid @RequestBody UpdateColorRequest updateColorRequest) {
        return colorService.update(updateColorRequest);
    }

    @GetMapping("{id}")
    public DataResult<ColorDetailResponse> getById(@PathVariable int id) {
        return colorService.getById(id);
    }
}
