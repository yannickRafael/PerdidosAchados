package com.sfs.perdidosachados.model;

import jakarta.persistence.*;

@Entity
@Table(name = "local")
public class Local {
    @Id
    @Column(name = "local_id", nullable = false)
    private Integer id;

    @Column(name = "local_name")
    private String localName;

    @Lob
    @Column(name = "local_description")
    private String localDescription;

    @Column(name = "local_coordinates")
    private String localCoordinates;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getLocalDescription() {
        return localDescription;
    }

    public void setLocalDescription(String localDescription) {
        this.localDescription = localDescription;
    }

    public String getLocalCoordinates() {
        return localCoordinates;
    }

    public void setLocalCoordinates(String localCoordinates) {
        this.localCoordinates = localCoordinates;
    }

}