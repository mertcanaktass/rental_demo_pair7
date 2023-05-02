package com.etiya.rentaldemopair7.business.dtos.requests.branch;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBranchRequest {

    @Positive(message = "Geçerli bir ID giriniz.")
    private int id;

    @NotEmpty(message = "İsim alanı boş bırakılamaz.")
    @Size(min = 2, max = 20, message = "Şube ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    @NotEmpty(message = "Şehir alanı boş bırakılamaz.")
    @Size(min = 2, max = 20, message = "Şehir alanı 2 ile 20 karakter arası olmalıdır!")
    private String city;
}
