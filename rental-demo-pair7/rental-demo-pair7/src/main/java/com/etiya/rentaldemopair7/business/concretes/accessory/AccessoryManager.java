package com.etiya.rentaldemopair7.business.concretes.accessory;

import com.etiya.rentaldemopair7.business.abstracts.accessory.AccessoryService;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.AddAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.AddAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.core.exceptions.BusinessException;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Accessory;
import com.etiya.rentaldemopair7.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryManager implements AccessoryService {
    private AccessoryRepository accessoryRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public AccessoryManager(AccessoryRepository accessoryRepository, ModelMapperService modelMapperService) {
        this.accessoryRepository = accessoryRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<ListAccessoryResponse> getAll() {
        return accessoryRepository.getAll();
    }

    @Override
    public DataResult<AddAccessoryResponse> add(AddAccessoryRequest addAccessoryRequest){
        Accessory addAccessory =
                accessoryRepository.findByName(addAccessoryRequest.getName());
        if (addAccessory != null)
            throw new BusinessException("Böyle bir aksesuar zaten mevcut!");

        //Manual Mapping
        //Accessory accessory = new Accessory();
        //accessory.setName(addAccessoryRequest.getName());
        //accessory.setAmount(addAccessoryRequest.getAmount());
        //accessory.setType(addAccessoryRequest.getType());
        //accessoryRepository.save(accessory);

        //Auto Mapping
        Accessory accessory = modelMapperService.forRequest().map(addAccessoryRequest, Accessory.class);
        accessoryRepository.save(accessory);

        //Manual Mapping
        //AddAccessoryResponse response = new AddAccessoryResponse();
        //response.setId(accessory.getId());
        //response.setName(accessory.getName());
        //response.setAmount(accessory.getAmount());
        //response.setType(accessory.getType());
        //return response;

        //Auto Mapping
        AddAccessoryResponse response = modelMapperService.forResponse().map(accessory, AddAccessoryResponse.class);
        return new SuccessDataResult<>(response, "Aksesuar eklendi.");

    }
}
