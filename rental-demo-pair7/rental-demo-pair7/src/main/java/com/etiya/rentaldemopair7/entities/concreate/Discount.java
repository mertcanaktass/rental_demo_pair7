package com.etiya.rentaldemopair7.entities.concreate;

import lombok.*;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="discount")
@Entity

public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "valid_date")
    private Date validDate;

    @OneToMany(mappedBy = "discount")
    private List<Accessory> accessories;

    @OneToMany(mappedBy = "discount")
    private List<Car> cars;
}
