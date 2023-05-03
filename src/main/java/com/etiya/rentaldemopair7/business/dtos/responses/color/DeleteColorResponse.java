package com.etiya.rentaldemopair7.business.dtos.responses.color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteColorResponse {
    private int id;
    private String name;
}
