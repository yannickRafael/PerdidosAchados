package com.sfs.perdidosachados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @Column(name = "phone_nr", nullable = false, length = 30)
    private String phoneNr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User idUser;

}