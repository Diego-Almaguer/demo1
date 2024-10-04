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
@Table(name = "profile")
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_sequence")
    @SequenceGenerator(name = "profile_sequence", sequenceName = "profile_sequence", allocationSize = 100)
    private Long id;
    @Column(name = "foto", nullable = true)
    private String foto;

    @OneToOne
    private User user;

}