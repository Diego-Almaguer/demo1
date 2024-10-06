package com.example.demo1.entity;

import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "osde")
public class Osde implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "osde_sequence")
    @SequenceGenerator(name = "osde_sequence", sequenceName = "osde_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre")
    @NotNull(message = "El nombre no puede ser nulo")

    private String nombre;

    @ManyToOne
    private Ministerio ministerio;

    @OneToMany(mappedBy = "osde", cascade = CascadeType.ALL)
    private List<Entidad> listaEntidades;

}