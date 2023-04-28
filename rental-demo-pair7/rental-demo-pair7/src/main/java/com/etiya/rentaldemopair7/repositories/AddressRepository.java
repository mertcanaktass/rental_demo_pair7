package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Address;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("SELECT ad FROM Address ad")
    List<Address> findAllAccessory();

    @Query("SELECT ad.id FROM Address ad")
    List<Integer> findAllAddressId();

    @Query("SELECT ad FROM Address ad")
    List<Address> sortAllAddress(Sort sort);
}