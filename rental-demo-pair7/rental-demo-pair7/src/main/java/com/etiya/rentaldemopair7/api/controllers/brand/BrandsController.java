package com.etiya.rentaldemopair7.api.controllers.brand;

import com.etiya.rentaldemopair7.business.abstracts.brand.BrandService;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.AddBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.AddBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")

public class BrandsController {

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    private BrandService brandService;

    @GetMapping("")
    public List<ListBrandResponse> getAll(){
        return brandService.getAll();
    }

    @PostMapping("")
    public AddBrandResponse add(@Valid @RequestBody AddBrandRequest addBrandRequest) throws Exception {
        return brandService.add(addBrandRequest);
    }
}