package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AccessoryRepository extends JpaRepository<Accessory,Integer> {

    Accessory findByName(String name);

}
