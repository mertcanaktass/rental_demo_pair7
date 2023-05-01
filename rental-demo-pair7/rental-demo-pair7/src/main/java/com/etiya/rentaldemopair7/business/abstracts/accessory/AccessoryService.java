package com.etiya.rentaldemopair7.business.abstracts.accessory;

import com.etiya.rentaldemopair7.business.dtos.requests.accessory.AddAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.AddAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;

import java.util.List;

public interface AccessoryService {

    List<ListAccessoryResponse> getAll();
    //git deneme

    AddAccessoryResponse add(AddAccessoryRequest addAccessoryRequest);

}
