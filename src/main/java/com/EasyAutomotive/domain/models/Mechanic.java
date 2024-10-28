package com.EasyAutomotive.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "mechanics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 180)
    private String technician;

    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL)
    private Set<ServiceOrder> serviceOrder;
}
