package com.etiya.rentaldemopair7.business.dtos.requests.car;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {


    @NotEmpty(message = "{carNotEmpty}")
    private String carModel;

    @Positive(message = "{carNotEmpty}")
    private int dailyPrice;

    @Positive(message = "{carNotEmpty}")
    private int discount;

    @Positive(message = "{carNotEmpty}")
    private int brand;

    @Positive(message = "{carNotEmpty}")
    private int colorId;

}
