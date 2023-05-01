package com.etiya.rentaldemopair7.business.dtos.requests.accessory;

import com.etiya.rentaldemopair7.entities.concreate.Discount;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccessoryRequest {
    @NotEmpty(message = "Id alanı boş bırakılamaz.")
    private int id;

    @NotEmpty(message = "İsim alanı boş bırakılamaz.")
    @Size(min = 2, max = 20, message = "Aksesuar ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    @NotEmpty(message = "Miktar alanı boş bırakılamaz.")
    @PositiveOrZero(message = "Miktar 0 veya büyük olmalı!")
    private int amount;

    @NotEmpty(message = "Tip alanı boş bırakılamaz.")
    @Size(min = 2, max = 20, message = "Aksesuar tipi 2 ile 20 karakter arası olmalıdır!")
    private String type;

    private int discount;
}
