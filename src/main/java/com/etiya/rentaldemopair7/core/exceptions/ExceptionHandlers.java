package com.etiya.rentaldemopair7.core.exceptions;

import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.exceptions.types.NotFoundException;
import com.etiya.rentaldemopair7.core.utils.result.ErrorResult;
import com.etiya.rentaldemopair7.core.utils.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBusinessException(BusinessException exception)
    {
        return new ErrorResult(exception.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleNotFoundException(NotFoundException exception){
        return new ErrorResult(exception.getMessage());
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleValidationException(MethodArgumentNotValidException exception){

        Map<String,String> errors = new HashMap<>();

        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }

}