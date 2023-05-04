package com.etiya.rentaldemopair7.business.abstracts.accessory;

import com.etiya.rentaldemopair7.business.dtos.requests.accessory.AddAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.UpdateAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.AddAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.UpdateAccessoryResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;

import javax.xml.crypto.Data;
import java.util.List;

public interface AccessoryService {

    DataResult<List<ListAccessoryResponse>> getAll();

    DataResult<AddAccessoryResponse> add(AddAccessoryRequest addAccessoryRequest);


    DataResult<UpdateAccessoryResponse> update(UpdateAccessoryRequest updateAccessoryRequest);
}
