package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "client_sequence", allocationSize = 1)
    @Column(name = "id_client", nullable = false)
    private Long idclient;

    @Column(name = "nom")
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_voiture", referencedColumnName = "id_voiture")
    private Voiture voiture;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<ContratLocation> contrat;
}