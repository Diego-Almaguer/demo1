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
@Table(name = "empresa")
public class Entidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_sequence")
    @SequenceGenerator(name = "empresa_sequence", sequenceName = "empresa_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String nombre;

    @ManyToOne
    private Osde osde;

    @OneToMany(mappedBy = "entidad")
    private List<Deficiencia> listaDeficiencias;
}