package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.entities.concreate.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccessoryRepository extends JpaRepository<Accessory,Integer> {

    Accessory findByName(String name);

    @Query(value="Select new com.etiya.rentaldemopair7.business.dtos.responses.accessory" +
            ".ListAccessoryResponse (a.id, a.name, a.amount, a.type, d.id) from" +
            " Accessory a JOIN a.discount d WHERE a.id=:id")
    ListAccessoryResponse getById(int id);

    boolean existsAccessoryById(int id);
}
