package com.EasyAutomotive.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 180)
    private String name;

    @Column(nullable = false, length = 180)
    private String lastname;

    @Column(nullable = false, length = 19)
    private String cpfCnpj;

    @Column(nullable = false, length = 180)
    private String email;

    @Column(nullable = false, length = 12)
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Car> cars;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<ServiceOrder> serviceOrder;
}
