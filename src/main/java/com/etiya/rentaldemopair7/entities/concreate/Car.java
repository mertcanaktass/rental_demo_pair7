package com.etiya.rentaldemopair7.entities.concreate;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "daily_price")
    private int dailyPrice;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<InsuranceCar> insuranceCarList;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    @JsonIgnore
    private Discount discount;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<CarAccessory> carAccessories;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<CarBranch> carBranches;

    @ManyToOne
    @JoinColumn(name = "color_id")
    @JsonIgnore
    private Color color;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<CarMaintenance> carMaintenances;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    @JsonIgnore
    private Rental rental;


}
