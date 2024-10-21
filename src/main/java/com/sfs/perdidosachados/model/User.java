package com.sfs.perdidosachados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "user_email", nullable = false, length = 50)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @OneToMany(mappedBy = "idUser")
    private Set<Claim> claims = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUser")
    private Set<Item> items = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUser")
    private Set<Phone> phones = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUser")
    private Set<Session> sessions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUser")
    private Set<UserRole> userRoles = new LinkedHashSet<>();

}