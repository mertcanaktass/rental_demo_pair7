package com.etiya.rentaldemopair7.business.abstracts.color;

import com.etiya.rentaldemopair7.business.dtos.requests.color.AddColorRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.UpdateColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.car.CarDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.AddColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ColorDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.UpdateColorResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ColorService {

    DataResult<List<ListColorResponse>> getAll();

    DataResult<Page<ListColorResponse>> getAllWithPaginatiion(Pageable pageable);

    DataResult<AddColorResponse> add(AddColorRequest addColorRequest);

    DataResult<UpdateColorResponse> update(UpdateColorRequest updateColorRequest);

    DataResult<ColorDetailResponse> getById(int id);
    Result colorWithIdShouldExist(int colorId);
}
