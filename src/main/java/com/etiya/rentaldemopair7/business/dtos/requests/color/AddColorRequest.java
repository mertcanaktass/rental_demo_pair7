package com.etiya.rentaldemopair7.business.dtos.requests.color;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddColorRequest {

    @NotEmpty(message = "{colorNotEmpty}")
    @Size(min = 2, max = 20, message = "{colorMustBeBetween}")
    private String name;

}
