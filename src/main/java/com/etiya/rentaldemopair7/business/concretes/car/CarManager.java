package com.etiya.rentaldemopair7.business.concretes.car;

import com.etiya.rentaldemopair7.business.abstracts.car.CarService;
import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.business.constants.Messages;
import com.etiya.rentaldemopair7.business.dtos.requests.car.AddCarRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.car.AddCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.CarDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.ListCarResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.car.UpdateCarResponse;
import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.Result;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Car;
import com.etiya.rentaldemopair7.repositories.CarRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ColorService colorService;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    public CarManager(CarRepository carRepository, ModelMapperService modelMapperService,
                      MessageSource messageSource,ColorService colorService) {
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
        this.messageSource = messageSource;
        this.colorService=colorService;
    }

    @Override
    public DataResult<List<ListCarResponse>> getAll() {
        return new SuccessDataResult<>(carRepository.getAll());
    }

/*    @Override
    public DataResult<Page<ListCarResponse>> getAllWithPaginatiion(Pageable pageable) {
        return new SuccessDataResult<>(carRepository.getAll(pageable));
    }*/

    @Override
    public DataResult<AddCarResponse> add(AddCarRequest addCarRequest) {
        checkIfCarWithSameNameExists(addCarRequest.getCarModel());

        Car car = modelMapperService.forResponse().map(addCarRequest,Car.class);
        colorWithIdShouldExist(addCarRequest.getColorId());
        carRepository.save(car);
        AddCarResponse response = modelMapperService.forResponse().map(car, AddCarResponse.class);
        return new SuccessDataResult<>(response, Messages.Car.CarAdded);

    }

    @Override
    public DataResult<UpdateCarResponse> update(UpdateCarRequest updateCarRequest) {
        Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        carRepository.save(car);

        UpdateCarResponse response = modelMapperService.forResponse().map(car, UpdateCarResponse.class);
        return new SuccessDataResult<>(response, Messages.Car.CarUpdated);

    }

    @Override
    public DataResult<CarDetailResponse> getById(int id) {
            return new SuccessDataResult<>(carRepository.getById(id));
    }


    private void colorWithIdShouldExist(int colorId) {
        Result colorExists = colorService.colorWithIdShouldExist(colorId);
        if (!colorExists.isSuccess()){
            throw new BusinessException(Messages.Color.ColorDoesNotExistsWithGivenId);
        }
    }

    private void checkIfCarWithSameNameExists(String carModel) {
        Car addCar =
                carRepository.findByCarModel(carModel);
        if (addCar != null)
            throw new BusinessException(messageSource.getMessage(Messages.Car.CarExists, null, LocaleContextHolder.getLocale()));
    }
}
