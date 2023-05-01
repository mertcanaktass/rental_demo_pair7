package com.etiya.rentaldemopair7.business.dtos.requests.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {


    @NotEmpty(message = "Id alanı boş olamaz.")
    private int id;

    @NotEmpty(message = "Müşteri ismi boş olamaz")
    @Size(min = 2, max = 20, message = "Müşteri ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    @NotEmpty(message = "Mail boş bırakılamaz!")
    @Email(message = "Doğru mail formatı giriniz.")
    private String mail;

    @Size(min = 11, max = 11, message = "Gsm no 11 karakter olmalıdır!")
    private String gsm;

    @NotEmpty(message = "Lisans tipi boş bırakılamaz!")
    private String licenceType;

    @NotEmpty(message = "Adres boş bırakılamaz!")
    private int address;
}
