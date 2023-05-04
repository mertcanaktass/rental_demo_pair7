package com.etiya.rentaldemopair7.business.concretes.brand;

import com.etiya.rentaldemopair7.business.abstracts.brand.BrandService;
import com.etiya.rentaldemopair7.business.constants.Messages;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.AddBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.AddBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.UpdateBrandResponse;
import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.internationalization.MessageService;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Brand;
import com.etiya.rentaldemopair7.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;
    
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService, MessageService  messageService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.messageService = messageService;
    }


    @Override
    public List<ListBrandResponse> getAll() {
        return brandRepository.getAll();
    }

    @Override
    public DataResult<AddBrandResponse> add(AddBrandRequest addBrandRequest){
        Brand addBrand =
                brandRepository.findByName(addBrandRequest.getName());
        if(addBrand != null)
            throw new BusinessException(messageService.getMessage(Messages.Brand.BrandExists));

        Brand brand = modelMapperService.forRequest().map(addBrandRequest, Brand.class);
        brandRepository.save(brand);

        AddBrandResponse response = modelMapperService.forResponse().map(brand, AddBrandResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Brand.SuccessAddBrand));
    }

    @Override
    public DataResult<UpdateBrandResponse> update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);

        UpdateBrandResponse response = modelMapperService.forResponse().map(brand, UpdateBrandResponse.class);
        return new SuccessDataResult<>(response, Messages.Brand.BrandUpdated);
    }
}

