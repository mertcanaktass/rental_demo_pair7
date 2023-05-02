package com.etiya.rentaldemopair7.business.dtos.requests.brand;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    @Positive(message = "Geçerli bir Id giriniz.")
    private int id;

    @NotEmpty(message = "İsim alanı boş bırakılamaz.")
    @Size(min = 2, max = 20, message = "Marka ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    private Date dateAdded;
}
