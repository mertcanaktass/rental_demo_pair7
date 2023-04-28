package com.etiya.rentaldemopair7.repositories;


import com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse;
import com.etiya.rentaldemopair7.entities.concreate.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    Brand findByName(String brand);

    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.brand.ListBrandResponse(br.id, br.name, br.dateAdded)" +
            "from Brand br")
    List<ListBrandResponse> getAll();
}
