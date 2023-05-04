package com.etiya.rentaldemopair7.business.dtos.requests.accessory;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAccessoryRequest {

    @NotEmpty(message = "İsim kısmı boş bırakılamaz!")
    @Size(min = 2, max = 20, message = "Aksesuar ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    @PositiveOrZero(message = "Miktar 0 veya büyük olmalı!")
    private int amount;

    @NotEmpty(message = "Tip kısmı boş bırakılamaz!")
    @Size(min = 2, max = 20, message = "Aksesuar tipi ismi 2 ile 20 karakter arası olmalıdır!")
    private String type;

    @Positive(message= "Geçerli bir discountId giriniz.")
    private int discountId;
}
