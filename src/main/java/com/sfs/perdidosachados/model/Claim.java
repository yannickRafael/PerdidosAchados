package com.sfs.perdidosachados.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "claim")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id", nullable = false)
    private Integer id;

    @Column(name = "claim_date", nullable = false)
    private Instant claimDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_item", nullable = false)
    private Item idItem;

    @Lob
    @Column(name = "claim_message")
    private String claimMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Instant claimDate) {
        this.claimDate = claimDate;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public String getClaimMessage() {
        return claimMessage;
    }

    public void setClaimMessage(String claimMessage) {
        this.claimMessage = claimMessage;
    }

}