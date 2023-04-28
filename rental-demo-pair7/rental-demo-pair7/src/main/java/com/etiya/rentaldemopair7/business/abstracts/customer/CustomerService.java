package com.etiya.rentaldemopair7.business.abstracts.customer;

import com.etiya.rentaldemopair7.entities.concreate.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    void add(Customer customer);
}
