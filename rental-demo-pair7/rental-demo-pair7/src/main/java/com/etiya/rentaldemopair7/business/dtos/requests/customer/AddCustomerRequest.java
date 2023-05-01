package com.etiya.rentaldemopair7.business.dtos.requests.customer;

import com.etiya.rentaldemopair7.entities.concreate.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {

    @NotEmpty(message = "müşteri ismi boş olamaz")
    @Size(min = 2, max = 20, message = "müşteri ismi 2 ile 20 karakter arası olamalıdır!")
    private String name;

    @NotEmpty
    @Email
    private String mail;

    @Size(min = 11, max = 11, message = "gsm no 11 karakter olmalıdır!")
    private String gsm;

    @NotEmpty
    private String licenceType;

    @NotEmpty
    private Address address;

}
