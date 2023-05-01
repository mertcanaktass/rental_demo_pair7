package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.customer.ListCustomerResponse;
import com.etiya.rentaldemopair7.entities.concreate.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByName (String name);
    Customer findByMail (String mail);
    Customer findByGsm (String gsm);

    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.customer.ListCustomerResponse(cu.id, cu.name,cu.mail, cu.gsm,cu.licenceType,ad.id)" +
            "from Customer cu JOIN cu.address ad", nativeQuery = false)
    List<ListCustomerResponse> getAll();


}
