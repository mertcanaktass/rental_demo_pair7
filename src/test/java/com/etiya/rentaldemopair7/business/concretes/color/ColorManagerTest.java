package com.etiya.rentaldemopair7.business.concretes.color;

import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.core.internationalization.MessageManager;
import com.etiya.rentaldemopair7.core.internationalization.MessageService;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.repositories.ColorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ColorManagerTest {

    ColorRepository colorRepository;
    ModelMapperService modelMapperService;
    MessageService messageService;
    ColorManager colorManager;


    @BeforeEach
    void setUp() {
        messageService  =  new MessageManager(getBundleMessageSource());
        colorRepository = mock(ColorRepository.class);
        colorManager = new ColorManager(colorRepository,modelMapperService,messageService);
    }

    public ResourceBundleMessageSource getBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @AfterEach
    void tearDown() {
    }
/*
    @Test
    void getAll() {
        List<ListColorResponse> expectedData = new ArrayList<>();
        expectedData.add(new ListColorResponse(1,"data1"));
        expectedData.add(new ListColorResponse(2,"data2"));
        when(colorRepository.getAll()).thenReturn(expectedData);
        DataResult<List<ListColorResponse>> actualResult= colorManager.getAll();

        assert expectedData.size() == actualResult
    }*/

}