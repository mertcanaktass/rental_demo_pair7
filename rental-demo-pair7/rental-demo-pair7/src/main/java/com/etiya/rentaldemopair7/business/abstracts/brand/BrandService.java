package com.etiya.rentaldemopair7.business.abstracts.brand;

import com.etiya.rentaldemopair7.business.dtos.requests.brand.AddBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.AddBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse;

import java.util.List;

public interface BrandService {

    List<ListBrandResponse> getAll();

    AddBrandResponse add(AddBrandRequest addBrandRequest) throws Exception;
}
