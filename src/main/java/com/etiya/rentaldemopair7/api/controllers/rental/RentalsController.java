package com.etiya.rentaldemopair7.api.controllers.rental;

import com.etiya.rentaldemopair7.business.abstracts.rental.RentalService;
import com.etiya.rentaldemopair7.business.dtos.requests.rental.AddRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.AddRentalResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.rental.UpdateRentalResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
    private RentalService rentalService;

    @Autowired
    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("")
    public DataResult<AddRentalResponse> add(@Valid @RequestBody AddRentalRequest addRentalRequest) {
        DataResult<AddRentalResponse> response = rentalService.add(addRentalRequest);
        return response;
    }

    @PutMapping("")
    public DataResult<UpdateRentalResponse> update(@Valid @RequestBody UpdateRentalRequest updateRentalRequest) {
        return rentalService.update(updateRentalRequest);
    }

}
