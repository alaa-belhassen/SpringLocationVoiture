package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="contrat_client")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrat_location_seq")
    @SequenceGenerator(name = "contrat_location_seq", sequenceName = "contrat_location_sequence", allocationSize = 1)
    @Column( name = "id_contrat_location",nullable = false)
    private Long idContratLocation;

    @Basic
    @Column( name ="datedepart")
    private Timestamp datedepart;

    @Basic
    @Column( name ="dateretour")
    private Timestamp dateretour;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="id_client")
    private Client client;

    @OneToOne(mappedBy="contrat", cascade = CascadeType.ALL)
    private Voiture voiture ;
}
