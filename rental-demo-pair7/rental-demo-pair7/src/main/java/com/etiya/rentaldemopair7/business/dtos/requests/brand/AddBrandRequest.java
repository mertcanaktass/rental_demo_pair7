package com.etiya.rentaldemopair7.business.dtos.requests.brand;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {

    @NotEmpty(message = "İsim boş olamaz!")
    @Size(min = 2, max = 20, message = "Marka ismi 2 ile 20 karakter arası olmalıdır!")
    private String name;

    //@FutureOrPresent(message = "Geçerli bir tarih gir!")
    private Date dateAdded;
}
