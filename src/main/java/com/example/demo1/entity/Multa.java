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
@Table(name = "multa")
public class Multa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "multa_sequence")
    @SequenceGenerator(name = "multa_sequence", sequenceName = "multa_sequence", allocationSize = 100)
    private Long id;

    @Column(name = "precio")
    private double precio;

    @Column(name = "descripcion")
    @NotNull(message = "error")
    private String descripcion;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    // @ManyToOne
    @Column(name = "entidad_id")
    @JoinColumn(name = "entidad")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer entidad;

    // @ManyToOne
    @Column(name = "inspector_id")
    @JoinColumn(name = "inspector")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer inspector;
}