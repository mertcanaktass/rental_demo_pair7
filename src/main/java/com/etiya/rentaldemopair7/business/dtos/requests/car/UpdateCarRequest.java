package com.etiya.rentaldemopair7.business.dtos.requests.car;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCarRequest {

    @Positive(message = "Geçerli bir id giriniz.")
    private int id;

    @NotEmpty(message = "Araba modeli boş olamaz")
    private String carModel;

    @Positive(message = "Geçerli bir fiyat giriniz.")
    private int dailyPrice;

    @Positive(message = "Geçerli bir indirim giriniz.")
    private int discount;

    @Positive(message = "Geçerli bir marka giriniz.")
    private int brand;

}
