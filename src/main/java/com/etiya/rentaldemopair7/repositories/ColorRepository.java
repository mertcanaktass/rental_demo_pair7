package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.business.dtos.responses.color.ColorDetailResponse;
import com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    Color findByName (String name);
    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse(c.id, c.name) from Color c")
    List<ListColorResponse> getAll();

    @Query(value="Select new com.etiya.rentaldemopair7.business.dtos.responses.color" +
            ".ColorDetailResponse (c.id, c.name) from Color c WHERE c.id=:id")
    ColorDetailResponse getById(int id);

    boolean existsColorById(int id);

    @Query(value = "select new " +
            "com.etiya.rentaldemopair7.business.dtos.responses.color.ListColorResponse(c.id, c.name) from Color c")
    Page<ListColorResponse> getAll(Pageable pageable);

}
