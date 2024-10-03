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

    @Column(name = "nombre")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String nombre;

    @OneToMany
    private List<Osde> listaOsdes;

}