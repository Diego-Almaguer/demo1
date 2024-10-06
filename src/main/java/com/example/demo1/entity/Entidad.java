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
@Table(name = "empresa")
public class Entidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_sequence")
    @SequenceGenerator(name = "empresa_sequence", sequenceName = "empresa_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre")
    @NotNull(message = "error")
    private String nombre;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Municipio municipio;

    @ManyToOne
    private Osde osde;

    @OneToMany(mappedBy = "entidad", cascade = CascadeType.ALL)
    private List<Deficiencia> listaDeficiencias;

    @OneToMany(mappedBy = "entidad", cascade = CascadeType.ALL)
    private List<Multa> listaMultas;
}