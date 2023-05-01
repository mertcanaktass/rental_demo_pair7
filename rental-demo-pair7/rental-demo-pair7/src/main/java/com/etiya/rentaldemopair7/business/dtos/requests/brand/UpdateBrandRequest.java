package com.etiya.rentaldemopair7.business.dtos.requests.brand;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    @NotEmpty(message = "Id alanı boş bırakılamaz.")
    private int id;

    @NotEmpty(message = "İsim alanı boş bırakılamaz.")
    @Size(min = 2, max = 20, message = "Marka ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;
}
