package com.pedro.contadordecommits.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "commit")
public class Commit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricaoCommit;

    @Column(name = "dataCommit")
    private Date dateCommit;

    @Column(name = "horaCommit")
    private String horaCommit;

    @Column(name = "userCommit")
    private String userCommit;

    @Column(name = "msgCommit")
    private String msgCommit;
    
}
