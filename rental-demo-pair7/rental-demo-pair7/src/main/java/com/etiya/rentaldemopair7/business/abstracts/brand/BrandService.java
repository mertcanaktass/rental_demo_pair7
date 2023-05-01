package com.etiya.rentaldemopair7.business.abstracts.brand;

import com.etiya.rentaldemopair7.business.dtos.requests.brand.AddBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.AddBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;

import java.util.List;

public interface BrandService {

    List<ListBrandResponse> getAll();

    DataResult<AddBrandResponse> add(AddBrandRequest addBrandRequest);
}
