package com.etiya.rentaldemopair7.entities.concreate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column
    private String name;

    @Column
    private String mail;

    @Column
    private String gsm;

    @Column(name = "licence_type")
    private String licenceType;

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    List<Invoice> invoices;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    List<Rental> rentals;

}
