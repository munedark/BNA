package com.Final.Back.Modles.Risques;

import com.Final.Back.Modles.Journales.JournalRisque;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "risque")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Risque {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "risque_id_Sequence")
    @SequenceGenerator(name = "risque_id_Sequence", sequenceName = "RISQUE_ID_SEQ")
    @Column(name="id",nullable=false,unique=true)
    private Long id;
    @Column(name = "SoldeRisque")
    private float soldeRisque;
    @Column(name = "MntFrais")
    private float mntFrais;
    @Column(name = "MntEntreePrincipale")
    private float mntEntreePrincipale;
    @Column(name = "Stade")
    private String stade;
    @Column(name = "IR")
    private float ir;
    @Column(name = "IC")
    private float ic;
    @Column(name="typeCloture")
    private String typeCloture;
    @OneToOne
    @JoinColumn(name = "idJournalRisque")
    private JournalRisque journalRisque;
    @OneToMany
    @JoinColumn(name = "risque_id")
    private List<DetailRisque> detailRisque;
    @OneToOne
    @JoinColumn(name = "risque_id")
    private Produit produit;
}
