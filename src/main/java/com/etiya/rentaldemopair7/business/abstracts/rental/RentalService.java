package com.etiya.rentaldemopair7.business.abstracts.rental;

import com.etiya.rentaldemopair7.business.dtos.requests.rental.AddRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.AddRentalResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.UpdateRentalResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;

public interface RentalService {

    DataResult<AddRentalResponse> add(AddRentalRequest addRentalRequest);

    DataResult<UpdateRentalResponse> update(UpdateRentalRequest updateRentalRequest);
}
