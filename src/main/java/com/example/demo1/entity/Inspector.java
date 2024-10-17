package com.example.demo1.entity;

import java.util.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "inspector")
public class Inspector implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inspector_sequence")
    @SequenceGenerator(name = "inspector_sequence", sequenceName = "inspector_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "ci", unique = true, length = 12)
    @NotEmpty(message = "el campo no puede estar vacio")
    @NotNull(message = "el campo no puede ser nulo")
    private String ci;

    @Column(name = "nombre")
    @NotEmpty(message = "el campo no puede estar vacio")
    @NotNull(message = "el campo no puede ser nulo")
    private String nombre;

    @Column(name = "apellido")
    @NotEmpty(message = "el campo no puede estar vacio")
    @NotNull(message = "el campo no puede ser nulo")
    private String apellido;

    @Column(name = "rango")
    @NotEmpty(message = "el campo no puede estar vacio")
    @NotNull(message = "el campo no puede ser nulo")
    private String rango;

    @Column(name = "edad")
    // @NotEmpty(message = "el campo no puede estar vacio")
    // @NotNull(message = "el campo no puede ser nulo")
    @Temporal(TemporalType.DATE)
    private Date edad;

    // @ManyToOne
    @Column(name = "municipio_id")
    @JoinColumn(name = "municipio")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer municipio;

    // @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL)
    // private List<Multa> listaMultas;

    // @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL)
    // private List<Deficiencia> listaDeficiencias;
}