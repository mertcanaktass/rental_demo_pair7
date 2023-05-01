package com.etiya.rentaldemopair7.business.dtos.responses.customer;

import com.etiya.rentaldemopair7.entities.concreate.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCustomerResponse {
    private int id;
    private String name;
    private String mail;
    private String gsm;
    private String licenceType;
    private int address;
}
