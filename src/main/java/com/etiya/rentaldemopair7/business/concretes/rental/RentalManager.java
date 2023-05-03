package com.etiya.rentaldemopair7.business.concretes.rental;

import com.etiya.rentaldemopair7.business.abstracts.rental.RentalService;
import com.etiya.rentaldemopair7.business.dtos.requests.rental.AddRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.AddRentalResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.UpdateRentalResponse;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.*;
import com.etiya.rentaldemopair7.entities.concreate.Rental;
import com.etiya.rentaldemopair7.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class RentalManager implements RentalService {
    private final MessageSource messageSource;
    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public RentalManager(MessageSource messageSource, RentalRepository rentalRepository, ModelMapperService modelMapperService) {
        this.messageSource = messageSource;
        this.rentalRepository = rentalRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<AddRentalResponse> add(AddRentalRequest addRentalRequest) {

        Rental rental = modelMapperService.forRequest().map(addRentalRequest,Rental.class);
        rentalRepository.save(rental);

        AddRentalResponse response = modelMapperService.forResponse().map(rental,AddRentalResponse.class);
        return new SuccessDataResult<>(response);

    }

    @Override
    public DataResult<UpdateRentalResponse> update(UpdateRentalRequest updateRentalRequest) {

        Rental rental = modelMapperService.forRequest().map(updateRentalRequest,Rental.class);
        rentalRepository.save(rental);

        UpdateRentalResponse response = modelMapperService.forResponse().map(rental,UpdateRentalResponse.class);
        return new DataResult<>(response,true,"rentalUpdated");
    }
}
