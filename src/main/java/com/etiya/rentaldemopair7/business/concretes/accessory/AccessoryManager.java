package com.etiya.rentaldemopair7.business.concretes.accessory;

import com.etiya.rentaldemopair7.business.abstracts.accessory.AccessoryService;
import com.etiya.rentaldemopair7.business.constants.Messages;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.AddAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.accessory.UpdateAccessoryRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.AddAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.accessory.UpdateAccessoryResponse;
import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.internationalization.MessageService;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Accessory;
import com.etiya.rentaldemopair7.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoryManager implements AccessoryService {
    private AccessoryRepository accessoryRepository;

    private ModelMapperService modelMapperService;

    private MessageService messageService;


    @Autowired
    public AccessoryManager(AccessoryRepository accessoryRepository, ModelMapperService modelMapperService, MessageService messageService) {
        this.accessoryRepository = accessoryRepository;
        this.modelMapperService = modelMapperService;
        this.messageService = messageService;
    }

    @Override
    public DataResult<List<ListAccessoryResponse>> getAll() {
        List<Accessory> accessories = accessoryRepository.findAll();
        List<ListAccessoryResponse> responses = accessories.stream()
                .map(accessory -> modelMapperService.forResponse().map(accessory,ListAccessoryResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses, Messages.Accessory.DataListed);
    }

    @Override
    public DataResult<AddAccessoryResponse> add(AddAccessoryRequest addAccessoryRequest){
        Accessory addAccessory =
                accessoryRepository.findByName(addAccessoryRequest.getName());
        if (addAccessory != null)
            throw new BusinessException(messageService.getMessage(Messages.Accessory.AccessoryExists));


        Accessory accessory = modelMapperService.forRequest().map(addAccessoryRequest, Accessory.class);
        accessoryRepository.save(accessory);

        AddAccessoryResponse response = modelMapperService.forResponse().map(accessory, AddAccessoryResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Accessory.SuccessAddAccessory));

    }

    @Override
    public DataResult<UpdateAccessoryResponse> update(UpdateAccessoryRequest updateAccessoryRequest) {
        Accessory accessory = modelMapperService.forRequest().map(updateAccessoryRequest, Accessory.class);
        accessoryRepository.save(accessory);

        UpdateAccessoryResponse response = modelMapperService.forResponse().map(accessory, UpdateAccessoryResponse.class);
        return new SuccessDataResult<>(response, Messages.Accessory.AccessoryUpdated);
    }
}

