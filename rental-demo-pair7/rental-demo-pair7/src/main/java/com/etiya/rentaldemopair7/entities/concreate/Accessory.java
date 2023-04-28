package com.etiya.rentaldemopair7.entities.concreate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accessories")
@Entity

public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column
    private String name;

    @Column
    private int amount;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    @JsonIgnore
    private Discount discount;

    @OneToMany(mappedBy = "accessory")
    @JsonIgnore
    private List<CarAccessory> carAccessories;
}
