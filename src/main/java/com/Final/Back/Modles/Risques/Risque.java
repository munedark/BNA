package com.Final.Back.Modles.Risques;

import com.Final.Back.Modles.Journales.JournalRisque;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "risque")
public class Risque {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "risque_id_Sequence")
    @SequenceGenerator(name = "risque_id_Sequence", sequenceName = "RISQUE_ID_SEQ")
    @Column(name="id",nullable=false,unique=true)
    private Long id;
    @Column(name = "SoldeRisque")
    private float SoldeRisque;
    @Column(name = "MntFrais")
    private float MntFrais;
    @Column(name = "MntEntreePrincipale")
    private float MntEntreePrincipale;
    @OneToOne
    @JoinColumn(name = "idJournalRisque")
    private JournalRisque journalRisque;
    @OneToMany
    @JoinColumn(name = "Detail")
    private List<DetailRisque> detailRisque;
    @OneToMany
    @JoinColumn(name = "produits")
    private List<Produit> produit;
}
