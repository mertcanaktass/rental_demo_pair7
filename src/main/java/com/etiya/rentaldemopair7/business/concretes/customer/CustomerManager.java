package com.etiya.rentaldemopair7.business.concretes.customer;

import com.etiya.rentaldemopair7.business.abstracts.customer.CustomerService;
import com.etiya.rentaldemopair7.business.constants.Messages;
import com.etiya.rentaldemopair7.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.rentaldemopair7.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.AddCustomerResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.ListCustomerResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.UpdateCustomerResponse;
import com.etiya.rentaldemopair7.core.exceptions.types.BusinessException;
import com.etiya.rentaldemopair7.core.internationalization.MessageService;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Customer;
import com.etiya.rentaldemopair7.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private MessageService messageService;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService, MessageService messageService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
        this.messageService = messageService;
    }

    @Override
    public List<ListCustomerResponse> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public DataResult<AddCustomerResponse> add(AddCustomerRequest addCustomerRequest) {
        Customer addCustomer =
                customerRepository.findByMail(addCustomerRequest.getMail());
        Customer addCustomer2 =
                customerRepository.findByGsm(addCustomerRequest.getGsm());
        if (addCustomer != null || addCustomer2 != null)
            throw new BusinessException(messageService.getMessage(Messages.Customer.CustomerExists));

        Customer customer = modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
        customerRepository.save(customer);


        AddCustomerResponse response = modelMapperService.forResponse().map(customer, AddCustomerResponse.class);
        return new SuccessDataResult<>(response, messageService.getMessage(Messages.Customer.SuccessAddCustomer));
    }

    @Override
    public DataResult<UpdateCustomerResponse> update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        customerRepository.save(customer);

        UpdateCustomerResponse response = modelMapperService.forResponse().map(customer, UpdateCustomerResponse.class);
        return new SuccessDataResult<>(response, Messages.Customer.CustomerUpdated);
    }
}
