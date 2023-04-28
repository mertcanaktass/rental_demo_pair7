package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    Color findByName (String name);

}
