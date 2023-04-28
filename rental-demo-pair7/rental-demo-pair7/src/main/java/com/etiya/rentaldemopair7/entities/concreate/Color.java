package com.etiya.rentaldemopair7.entities.concreate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="color")
@Entity

public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "color")
    @JsonIgnore
    List<CarColor> carColors;




}

