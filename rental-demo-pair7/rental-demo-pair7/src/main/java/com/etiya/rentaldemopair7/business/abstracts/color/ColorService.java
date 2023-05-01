package com.etiya.rentaldemopair7.business.abstracts.color;

import com.etiya.rentaldemopair7.business.dtos.requests.color.AddColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.color.AddColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.entities.concreate.Color;

import java.util.List;

public interface ColorService {

    List<ListColorResponse> getAll();

    DataResult<AddColorResponse> add(AddColorRequest addColorRequest);
}
