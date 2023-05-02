package com.etiya.rentaldemopair7.business.dtos.responses.branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBranchResponse {
    private int id;
    private String name;
    private String city;
}
