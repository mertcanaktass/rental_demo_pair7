package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.business.dtos.responses.accessory.ListAccessoryResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    Color findByName (String name);
    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse(c.id, c.name) from Color c")
    List<ListColorResponse> getAll();

}
