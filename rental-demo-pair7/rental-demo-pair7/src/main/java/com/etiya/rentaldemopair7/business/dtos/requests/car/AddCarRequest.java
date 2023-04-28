package com.etiya.rentaldemopair7.business.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCarRequest {
    private int id;
    private int brand;

}
