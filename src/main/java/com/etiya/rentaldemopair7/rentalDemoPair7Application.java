package com.etiya.rentaldemopair7;

import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.utils.result.ErrorResult;
import com.etiya.rentaldemopair7.core.utils.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@SpringBootApplication
@RestControllerAdvice
public class rentalDemoPair7Application {

    public static void main(String[] args) {
        SpringApplication.run(rentalDemoPair7Application.class, args);
    }

    @Bean
    public ResourceBundleMessageSource bundleMessageSource() {

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);

        return acceptHeaderLocaleResolver;
    }

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

}


