package com.etiya.rentaldemopair7.entities.concreate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="brand")
@Entity

public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column
    private String name;

    @Column(name = "date_added")
    private Date dateAdded;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<BrandCarType> brandCarTypes;
}
