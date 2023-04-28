package com.etiya.rentaldemopair7.entities.concreate;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="car_type")
@Entity

public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "carType")
    private List<BrandCarType> brandCarTypes;
}
