package com.etiya.rentaldemopair7.business.dtos.requests.branch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBranchRequest {
    @NotNull(message = "İsim kısmı boş bırakılamaz!")
    @NotBlank(message = "İsim kısmı boş bırakılamaz!!!")
    @Size(min = 2, max = 20, message = "Aksesuar ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    @NotNull(message =  "City boş olamaz!")
    @NotBlank(message = "City boş olamaz!!!")
    @Size(min = 2, max = 20, message = "City 2 ile 20 karakter arası olamalıdır!")
    private String city;
}
