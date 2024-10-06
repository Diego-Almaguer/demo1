package com.example.demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ministerio")
public class Ministerio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ministerio_sequence")
    @SequenceGenerator(name = "ministerio_sequence", sequenceName = "ministerio_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre", unique = true)
    @NotNull(message = "El nombre no puede ser nulo")

    private String nombre;

    @OneToMany(mappedBy = "ministerio", cascade = CascadeType.ALL)
    private List<Osde> listaOsdes;

}