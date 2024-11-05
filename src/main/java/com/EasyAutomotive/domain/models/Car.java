package com.EasyAutomotive.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 180)
    private String model;

    @Column(nullable = false, length = 180)
    private String brand;

    @Column(nullable = false, length = 4)
    private int modelYear;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<ServiceOrder> serviceOrder;

}
