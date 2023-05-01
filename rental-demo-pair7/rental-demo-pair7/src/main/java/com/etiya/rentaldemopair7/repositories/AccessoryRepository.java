package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.entities.concreate.Accessory;
import com.etiya.rentaldemopair7.entities.concreate.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AccessoryRepository extends JpaRepository<Accessory,Integer> {


    Accessory findByName(String name);

    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse(a.id, a.name,a.amount, a.type, a.discount) " +
            "from Accessory a")
    List<ListAccessoryResponse> getAll();


}
