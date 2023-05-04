package com.etiya.rentaldemopair7.business.abstracts.accessory;

import com.etiya.rentaldemopair7.business.dtos.requests.accessory.AddAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.DeleteAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.UpdateAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.DeleteColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.*;
import com.etiya.rentaldemopair7.business.dtos.responses.color.DeleteColorResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;

import javax.xml.crypto.Data;
import java.util.List;

public interface AccessoryService {

    DataResult<List<ListAccessoryResponse>> getAll();

    DataResult<AddAccessoryResponse> add(AddAccessoryRequest addAccessoryRequest);

    DataResult<UpdateAccessoryResponse> update(UpdateAccessoryRequest updateAccessoryRequest);

    DataResult<DeleteAccessoryResponse> delete(DeleteAccessoryRequest deleteAccessoryRequest);

    DataResult<ListAccessoryResponse> getById(int id);
}
