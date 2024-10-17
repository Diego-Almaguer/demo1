package com.example.demo1.entity;

import java.util.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name = "nombre", unique = true)
    @NotNull(message = "El nombre no puede ser nulo")

    private String nombre;

    // @ManyToOne
    @Column(name = "ministerio_id")
    @JoinColumn(name = "ministerio")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer ministerio;

    @OneToMany(mappedBy = "osde", cascade = CascadeType.ALL)
    private List<Entidad> listaEntidades;

}