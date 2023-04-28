package com.etiya.rentaldemopair7.business.concretes.brand;

import com.etiya.rentaldemopair7.business.abstracts.brand.BrandService;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.AddBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.AddBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse;
import com.etiya.rentaldemopair7.core.exceptions.BusinessException;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.entities.concreate.Brand;
import com.etiya.rentaldemopair7.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BrandManager implements BrandService {
    
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    private BrandRepository brandRepository;
private ModelMapperService modelMapperService;

    @Override
    public List<ListBrandResponse> getAll() {
        return brandRepository.getAll();
    }

    @Override
    public AddBrandResponse add(AddBrandRequest addBrandRequest){
        Brand addBrand =
                brandRepository.findByName(addBrandRequest.getName());
        if(addBrand != null)
            throw new BusinessException("Böyle bir marka zaten mevcut!");

        Brand brand = modelMapperService.forRequest().map(addBrandRequest, Brand.class);
        brandRepository.save(brand);

        AddBrandResponse response = modelMapperService.forResponse().map(brand, AddBrandResponse.class);
        return response;
    }

}

