package com.example.demo1.entity;

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
@Table(name = "problema")
public class Problema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "problema_sequence")
    @SequenceGenerator(name = "problema_sequence", sequenceName = "problema_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String nombre;

    @Column(name = "descripcion")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String descripcion;

    // @ManyToOne
    // private Empresa empresa;

}