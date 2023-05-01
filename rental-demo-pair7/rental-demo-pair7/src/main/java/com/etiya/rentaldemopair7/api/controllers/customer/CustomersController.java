package com.etiya.rentaldemopair7.api.controllers.customer;

import com.etiya.rentaldemopair7.business.abstracts.customer.CustomerService;
import com.etiya.rentaldemopair7.business.dtos.requests.color.UpdateColorRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.color.UpdateColorResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.AddCustomerResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.ListCustomerResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.UpdateCustomerResponse;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.entities.concreate.Customer;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {

    private CustomerService customerService;

    @GetMapping("")
    public List<ListCustomerResponse> getAll() {
        return customerService.getAll();
    }

    @PostMapping("")
    public DataResult<AddCustomerResponse> add(@Valid @RequestBody AddCustomerRequest addCustomerRequest) {
        return customerService.add(addCustomerRequest);
    }

    @PutMapping("")
    public DataResult<UpdateCustomerResponse> update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.update(updateCustomerRequest);
    }
}
