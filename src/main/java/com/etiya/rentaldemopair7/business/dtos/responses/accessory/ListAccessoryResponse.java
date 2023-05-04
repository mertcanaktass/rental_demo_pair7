package com.etiya.rentaldemopair7.business.dtos.responses.accessory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAccessoryResponse {
    private int id;
    private String name;
    private int amount;
    private String type;
    private int discountId;

}
