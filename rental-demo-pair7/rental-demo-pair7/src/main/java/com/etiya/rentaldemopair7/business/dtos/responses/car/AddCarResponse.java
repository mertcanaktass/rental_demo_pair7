package com.etiya.rentaldemopair7.business.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCarResponse {
    private int id;
    private int brand;
    private int discount;
    private int dailyPrice;
}
