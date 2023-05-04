package com.etiya.rentaldemopair7.business.concretes.rental;

import com.etiya.rentaldemopair7.business.abstracts.rental.RentalService;
import com.etiya.rentaldemopair7.business.constants.Messages;
import com.etiya.rentaldemopair7.business.dtos.requests.rental.AddRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.AddRentalResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.UpdateRentalResponse;
import com.etiya.rentaldemopair7.core.internationalization.MessageService;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.*;
import com.etiya.rentaldemopair7.entities.concreate.Rental;
import com.etiya.rentaldemopair7.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class RentalManager implements RentalService {

    private final MessageService messageService;
    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public RentalManager(MessageService messageService, RentalRepository rentalRepository, ModelMapperService modelMapperService) {
        this.messageService = messageService;
        this.rentalRepository = rentalRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<AddRentalResponse> add(AddRentalRequest addRentalRequest) {

        Rental rental = modelMapperService.forRequest().map(addRentalRequest,Rental.class);
        rentalRepository.save(rental);

        AddRentalResponse response = modelMapperService.forResponse().map(rental,AddRentalResponse.class);
        return new SuccessDataResult<>(response, Messages.Rental.SuccessAddRental);
    }

    @Override
    public DataResult<UpdateRentalResponse> update(UpdateRentalRequest updateRentalRequest) {

        Rental rental = modelMapperService.forRequest().map(updateRentalRequest,Rental.class);
        rentalRepository.save(rental);

        UpdateRentalResponse response = modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);
        return new SuccessDataResult<>(response, Messages.Rental.RentalUpdated);
    }
}
