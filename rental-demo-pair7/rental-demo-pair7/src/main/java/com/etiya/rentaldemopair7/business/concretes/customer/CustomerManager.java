package com.etiya.rentaldemopair7.business.concretes.customer;

import com.etiya.rentaldemopair7.business.abstracts.customer.CustomerService;
import com.etiya.rentaldemopair7.business.dtos.requests.customer.AddCustomerRequest;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.AddCustomerResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.ListCustomerResponse;
import com.etiya.rentaldemopair7.core.exceptions.BusinessException;
import com.etiya.rentaldemopair7.core.utils.mapping.ModelMapperService;
import com.etiya.rentaldemopair7.core.utils.result.DataResult;
import com.etiya.rentaldemopair7.core.utils.result.SuccessDataResult;
import com.etiya.rentaldemopair7.entities.concreate.Accessory;
import com.etiya.rentaldemopair7.entities.concreate.Customer;
import com.etiya.rentaldemopair7.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService, MessageSource messageSource) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
        this.messageSource = messageSource;
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
        if(addCustomer != null  || addCustomer2 != null)
            throw new BusinessException(messageSource.getMessage("customerExists",null, LocaleContextHolder.getLocale()));

        Customer customer = modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
        customerRepository.save(customer);


        AddCustomerResponse response = modelMapperService.forResponse().map(customer,AddCustomerResponse.class);
        return new SuccessDataResult<>(response,"müşteri eklendi");
    }
}
