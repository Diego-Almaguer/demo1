package com.example.demo1.entity;

import jakarta.persistence.*;
//import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

}