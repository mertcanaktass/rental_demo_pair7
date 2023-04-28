package com.etiya.rentaldemopair7.entities.concreate;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="insurance")
@Entity

public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column
    private String type;

    @Column
    private int price;

    @Column
    private String date;

    @OneToMany(mappedBy = "insurance")
    private List<InsuranceCar> insuranceCarList;
}
