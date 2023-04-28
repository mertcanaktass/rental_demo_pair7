package com.etiya.rentaldemopair7.api.controllers.customer;

import com.etiya.rentaldemopair7.business.abstracts.customer.CustomerService;
import com.etiya.rentaldemopair7.entities.concreate.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {

    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PostMapping("")
    public void add(Customer customer){
        customerService.add(customer);
    }
}
