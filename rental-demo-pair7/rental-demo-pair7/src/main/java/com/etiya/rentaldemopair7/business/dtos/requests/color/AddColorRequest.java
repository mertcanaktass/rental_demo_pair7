package com.etiya.rentaldemopair7.business.dtos.requests.color;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddColorRequest {

    @NotNull(message = "renk ismi boş olamaz")
    @Size(min = 2, max = 20, message = "RENK 2 ile 20 karakter arası olamalıdır!")
    private String name;

}
