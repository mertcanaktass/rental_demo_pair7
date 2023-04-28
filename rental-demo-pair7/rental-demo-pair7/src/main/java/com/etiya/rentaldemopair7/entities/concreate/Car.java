package com.etiya.rentaldemopair7.entities.concreate;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="car")
@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<InsuranceCar> insuranceCarList;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Column(name = "daily_price")
    private int dailyPrice;

    @OneToMany(mappedBy = "car")
    private List<CarAccessory> carAccessories;

    @OneToMany(mappedBy = "car")
    private List<CarBranch> carBranches;

    @OneToMany(mappedBy = "car")
    private List<CarColor> carColors;

    @OneToMany(mappedBy = "car")
    private List<CarMaintenance> carMaintenances;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;


}
