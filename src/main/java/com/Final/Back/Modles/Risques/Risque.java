package com.Final.Back.Modles.Risques;

import com.Final.Back.Modles.CompteBancaire.AgenceBank;
import com.Final.Back.Modles.Journales.JournalRisque;
import com.Final.Back.TypeCredit.TypeCredit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    @Column(name = "dateTransfert")
    private LocalDate dateTransfert;
    @Column(name = "SoldePrincipaleRisque")
    private float soldePrincipaleRisque;
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
    @OneToOne
    @JoinColumn(name = "detailRisque_id")
    private DetailRisque detailRisque;
    @OneToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "agence_bank_id", referencedColumnName = "idAgence" )
    private AgenceBank agenceBank;
    @ManyToOne
    @JoinColumn(name="typeCredit_id")
    private TypeCredit typeCredit;

}
