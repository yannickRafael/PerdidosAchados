package com.sfs.perdidosachados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", nullable = false)
    private Integer id;

    @Column(name = "session_token")
    private String sessionToken;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "session_start", nullable = false)
    private Instant sessionStart;

    @Column(name = "session_end", nullable = false)
    private Instant sessionEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User idUser;

}