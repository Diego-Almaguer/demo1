package com.example.demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 100)
    private Integer id;

    @Column(name = "nombre")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String nombre;

    @Column(name = "apellido")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String apellido;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(name = "username", unique = true)
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String username;

    @Column(name = "password")
    @NotNull(message = "error")
    @NotBlank(message = "")
    private String password;

    @Column(name = "created")
    @Temporal(TemporalType.DATE)

    private Date created;

    @Column(name = "admin")

    @NotNull(message = "error")
    private boolean admin;

    public boolean getAdmin() {
        return this.admin;

    }

}