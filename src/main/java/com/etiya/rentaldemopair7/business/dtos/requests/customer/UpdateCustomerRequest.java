package com.etiya.rentaldemopair7.business.dtos.requests.customer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {


    @Positive(message = "Geçerli bir Id giriniz.")
    private int id;

    @NotEmpty(message = "Müşteri ismi boş olamaz")
    @Size(min = 2, max = 20, message = "Müşteri ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    @NotEmpty(message = "Mail boş bırakılamaz!")
    @Email(message = "Doğru mail formatı giriniz.")
    private String mail;

    @NotEmpty(message = "Gsm boş bırakılamaz!")
    @Size(min = 11, max = 11, message = "Gsm no 11 karakter olmalıdır!")
    private String gsm;

    @NotEmpty(message = "Lisans tipi boş bırakılamaz!")
    private String licenceType;

    @Positive(message = "Geçerli bir addressId giriniz.")
    private int address;
}
