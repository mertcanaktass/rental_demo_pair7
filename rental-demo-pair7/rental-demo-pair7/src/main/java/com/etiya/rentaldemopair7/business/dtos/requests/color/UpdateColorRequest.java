package com.etiya.rentaldemopair7.business.dtos.requests.color;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {

    @NotEmpty(message = "Id alanı boş bırakılamaz.")
    private int id;

    @NotEmpty(message = "İsim alanı boş bırakılamaz.")
    @Size(min = 2, max = 20, message = "Renk ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;
}
