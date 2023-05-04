package com.etiya.rentaldemopair7.business.dtos.requests.accessory;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteAccessoryRequest {

    @Positive(message = "Geçerli bir id girin!")
    private int id;
}
