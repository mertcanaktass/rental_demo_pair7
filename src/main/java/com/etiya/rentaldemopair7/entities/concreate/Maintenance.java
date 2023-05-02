package com.etiya.rentaldemopair7.entities.concreate;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="maintenance")
@Entity

public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column
    private String type;

    @Column
    private int price;

    @OneToMany(mappedBy = "maintenance")
    private List<CarMaintenance> carMaintenances;
}
