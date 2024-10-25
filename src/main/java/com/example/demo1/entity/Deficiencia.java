package com.example.demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "deficiencia")
public class Deficiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deficiencia_sequence")
    @SequenceGenerator(name = "deficiencia_sequence", sequenceName = "deficiencia_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre")
    @NotNull(message = "error")
    private String nombre;

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