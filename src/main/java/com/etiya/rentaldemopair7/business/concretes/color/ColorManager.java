package com.etiya.rentaldemopair7.business.concretes.color;

import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.business.constants.Messages;
import com.etiya.rentaldemopair7.business.dtos.requests.color.AddColorRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.color.UpdateColorRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.color.AddColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ColorDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.UpdateColorResponse;
import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.exceptions.types.NotFoundException;
import com.etiya.rentaldemopair7.core.internationalization.MessageService;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.*;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import com.etiya.rentaldemopair7.repositories.ColorRepository;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;

    public ColorManager(ColorRepository colorRepository, ModelMapperService modelMapperService, MessageService messageService) {
        this.colorRepository = colorRepository;
        this.modelMapperService = modelMapperService;
        this.messageService = messageService;
    }
    @Override
    public DataResult<List<ListColorResponse>> getAll() {
        return new SuccessDataResult<>(colorRepository.getAll());
    }
    @Override
    public DataResult<AddColorResponse> add(AddColorRequest addColorRequest) {
        checkIfColorWithSameNameExists(addColorRequest.getName());

        Color color = modelMapperService.forRequest().map(addColorRequest,Color.class);
        colorRepository.save(color);

        AddColorResponse response = modelMapperService.forResponse().map(color,AddColorResponse.class);
        return new SuccessDataResult<>(response);
    }


    @Override
    public DataResult<UpdateColorResponse> update(UpdateColorRequest updateColorRequest) {

        Color color = colorRepository.findById(updateColorRequest.getId()).orElseThrow(() ->new NotFoundException(
                messageService.getMessageWithParams(Messages.Color.ColorDoesNotExistsWithGivenId,updateColorRequest.getId())));

        Color color1 = modelMapperService.forRequest().map(updateColorRequest, Color.class);
        colorRepository.save(color1);

        UpdateColorResponse response = modelMapperService.forResponse().map(color, UpdateColorResponse.class);
        return new DataResult<>(response, true, "colorUpdated");
    }


    @Override
    public DataResult<ColorDetailResponse> getById(int id) {
        return new SuccessDataResult<>(colorRepository.getById(id));
    }

    @Override
    public Result colorWithIdShouldExist(int colorId) {
        boolean isColorExists = colorRepository.existsColorById(colorId);
        if(isColorExists)
            return new SuccessResult();
        return new ErrorResult();
    }


    private void checkIfColorWithSameNameExists(String colorName){
        Color addColor =
                colorRepository.findByName(colorName);
        if(addColor != null)
            throw new BusinessException(messageService.getMessage(Messages.Color.ColorExists));
    }
}
