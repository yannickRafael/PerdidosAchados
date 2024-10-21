package com.sfs.perdidosachados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "local")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id", nullable = false)
    private Integer id;

    @Column(name = "local_name", nullable = false, length = 50)
    private String localName;

    @Column(name = "local_description")
    private String localDescription;

    @Column(name = "local_link")
    private String localLink;

    @OneToMany(mappedBy = "idLocal")
    private Set<Item> items = new LinkedHashSet<>();

}