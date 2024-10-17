package com.example.demo1.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio_sequence")
    @SequenceGenerator(name = "municipio_sequence", sequenceName = "municipio_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre", unique = true)
    private String nombre;
}