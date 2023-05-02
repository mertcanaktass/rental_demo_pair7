package com.etiya.rentaldemopair7.business.concretes.color;

import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.AddColorRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.UpdateColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.brand.UpdateBrandResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.AddColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.UpdateColorResponse;
import com.etiya.rentaldemopair7.core.exceptions.BusinessException;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Brand;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import com.etiya.rentaldemopair7.repositories.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;


    public ColorManager(ColorRepository colorRepository, ModelMapperService modelMapperService, MessageSource messageSource) {
        this.colorRepository = colorRepository;
        this.modelMapperService = modelMapperService;
        this.messageSource = messageSource;
    }

    @Override
    public List<ListColorResponse> getAll() {
        return colorRepository.getAll();
    }

    @Override
    public DataResult<AddColorResponse> add(AddColorRequest addColorRequest) {
        Color addColor =
                colorRepository.findByName(addColorRequest.getName());
        if(addColor != null)
            throw new BusinessException(messageSource.getMessage("colorExists",null, LocaleContextHolder.getLocale()));


        Color color = modelMapperService.forRequest().map(addColorRequest,Color.class);
        colorRepository.save(color);

        AddColorResponse response = modelMapperService.forResponse().map(color,AddColorResponse.class);
        return new SuccessDataResult<>(response, messageSource.getMessage("successAddColor", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<UpdateColorResponse> update(UpdateColorRequest updateColorRequest) {
        Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
        colorRepository.save(color);

        UpdateColorResponse response = modelMapperService.forResponse().map(color, UpdateColorResponse.class);
        return new DataResult<>(response, true, "colorUpdated");
    }
}
