package com.etiya.rentaldemopair7.entities.concreate;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="brand_car_type")
@Entity

public class BrandCarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
