package com.etiya.rentaldemopair7.repositories;

import com.etiya.rentaldemopair7.entities.concreate.Maintenance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
    @Query("SELECT m FROM Maintenance m")
    List<Maintenance> findAllMaintenance();

    @Query("SELECT m.id FROM Maintenance m")
    List<Integer> findAllMaintenanceId();

    @Query("SELECT m FROM Maintenance m")
    List<Maintenance> sortAllMaintenance(Sort sort);
}
