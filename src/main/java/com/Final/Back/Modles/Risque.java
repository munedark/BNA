package com.Final.Back.Modles;

import javax.persistence.*;

@Entity
@Table(name = "risque")
public class Risque {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="id",nullable=false,unique=true)
    private Long id;
    @Column(name = "SoldeRisque")
    private float SoldeRisque;
    @Column(name = "MntFrais")
    private float MntFrais;
    @Column(name = "MntEntreePrincipale")
    private float MntEntreePrincipale;
}
