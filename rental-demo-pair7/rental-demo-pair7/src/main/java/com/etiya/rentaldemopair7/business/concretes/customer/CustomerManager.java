package com.etiya.rentaldemopair7.business.concretes.customer;

import com.etiya.rentaldemopair7.business.abstracts.customer.CustomerService;
import com.etiya.rentaldemopair7.entities.concreate.Customer;
import com.etiya.rentaldemopair7.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        Customer addCustomer =
                customerRepository.findByMail(customer.getMail());
        Customer addCustomer2 =
                customerRepository.findByGsm(customer.getGsm());
        if(addCustomer != null  || addCustomer2 != null)
            return;
        customerRepository.save(customer);

    }
}
