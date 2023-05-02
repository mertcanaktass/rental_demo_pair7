package com.etiya.rentaldemopair7.business.dtos.responses.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandResponse {
    private int id;
    private String name;
    private Date dateAdded;
}
