package com.sfs.perdidosachados.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "resolv")
public class Resolv {
    @Id
    @Column(name = "resolv_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_userR")
    private User idUserr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_userV")
    private User idUserv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item")
    private Item idItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_local")
    private Local idLocal;

    @Column(name = "resolv_date")
    private Instant resolvDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getIdUserr() {
        return idUserr;
    }

    public void setIdUserr(User idUserr) {
        this.idUserr = idUserr;
    }

    public User getIdUserv() {
        return idUserv;
    }

    public void setIdUserv(User idUserv) {
        this.idUserv = idUserv;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public Local getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
    }

    public Instant getResolvDate() {
        return resolvDate;
    }

    public void setResolvDate(Instant resolvDate) {
        this.resolvDate = resolvDate;
    }

}