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
@Table(name = "multa")
public class Multa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "multa_sequence")
    @SequenceGenerator(name = "multa_sequence", sequenceName = "multa_sequence", allocationSize = 100)
    private Long id;

    @Column(name = "nombre")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String nombre;

    @Column(name = "descripcion")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String descripcion;

    @ManyToOne
    private Entidad entidad;

    @ManyToOne
    private Profile profile;

}