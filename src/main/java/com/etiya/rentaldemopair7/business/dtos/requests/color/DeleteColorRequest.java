package com.etiya.rentaldemopair7.business.dtos.requests.color;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteColorRequest {

    @Positive(message = "{colorIdNotEmpty}")
    private int id;
}
