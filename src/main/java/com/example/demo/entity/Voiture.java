package com.example.demo.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="voiture")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Voiture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voiture_seq")
    @SequenceGenerator(name = "voiture_seq", sequenceName = "voiture_sequence", allocationSize = 1)
    @Column( name = "id_voiture",nullable = false)
    private Long idVoiture;

    @Basic
    @Column( name ="couleur")
    private String couleur;

    @Basic
    @Column( name ="matricule")
    private String matricule;

    @Basic
    @Column(name = "disponible", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean disponible;

    @Timestamp
    @Column(name = "date_location")
    private LocalDateTime dateLocation;

    @OneToMany( mappedBy = "voiture" ,fetch = FetchType.LAZY)
    private List<Client> client;

    @OneToOne
    @JoinColumn(name="id_contrat_location")
    private ContratLocation contrat ;
}
