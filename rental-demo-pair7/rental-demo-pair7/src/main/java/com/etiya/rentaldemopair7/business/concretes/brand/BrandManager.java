package com.etiya.rentaldemopair7.business.concretes.brand;

import com.etiya.rentaldemopair7.business.abstracts.brand.BrandService;
import com.etiya.rentaldemopair7.business.dtos.requests.branch.UpdateBranchRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.AddBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.branch.UpdateBranchResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.AddBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.UpdateBrandResponse;
import com.etiya.rentaldemopair7.core.exceptions.BusinessException;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Branch;
import com.etiya.rentaldemopair7.entities.concreate.Brand;
import com.etiya.rentaldemopair7.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;
    
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService, MessageSource messageSource) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.messageSource=messageSource;
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
            throw new BusinessException(messageSource.getMessage("brandExists", null, LocaleContextHolder.getLocale()));

        Brand brand = modelMapperService.forRequest().map(addBrandRequest, Brand.class);
        brandRepository.save(brand);

        AddBrandResponse response = modelMapperService.forResponse().map(brand, AddBrandResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage("successAddBrand", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<UpdateBrandResponse> update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        if(brand != null)
            throw new BusinessException(messageSource.getMessage("brandExists", null, LocaleContextHolder.getLocale()));
        brandRepository.save(brand);

        UpdateBrandResponse response = modelMapperService.forResponse().map(brand, UpdateBrandResponse.class);
        return new DataResult<>(response, true, "brandUpdated");
    }

}

