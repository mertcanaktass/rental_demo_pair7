package com.etiya.rentaldemopair7.business.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarResponse {
    private int id;
    private String carModel;
    private int dailyPrice;
    private int discount;
    private int brand;
}
