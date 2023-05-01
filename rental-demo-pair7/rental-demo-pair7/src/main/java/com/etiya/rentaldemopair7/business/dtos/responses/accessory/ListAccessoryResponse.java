package com.etiya.rentaldemopair7.business.dtos.responses.accessory;

import com.etiya.rentaldemopair7.entities.concreate.Discount;
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
    private Discount discount;

}
