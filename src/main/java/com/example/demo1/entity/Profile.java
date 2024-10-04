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
    private Long id;
    @Column(name = "foto", nullable = true)
    private String foto;

    @Column(name = "username", unique = true)
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String username;

    @Column(name = "password")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String password;

    @OneToMany(mappedBy = "profile")
    private List<Deficiencia> listaDeficiencias;

    @OneToMany(mappedBy = "profile")
    private List<Multa> listaMultas;

    @OneToOne
    private User user;

}