package com.example.demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "profile")
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_sequence")
    @SequenceGenerator(name = "profile_sequence", sequenceName = "profile_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "foto")
    private String foto;

    @OneToMany(mappedBy = "profile")
    private List<Deficiencia> listaDeficiencias;

    @OneToMany(mappedBy = "profile")
    private List<Multa> listaMultas;

    @OneToOne
    private User user;

}