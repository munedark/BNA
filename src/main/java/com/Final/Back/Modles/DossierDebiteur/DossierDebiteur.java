package com.Final.Back.Modles.DossierDebiteur;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.Journales.JournalDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class DossierDebiteur {
    @EmbeddedId
    private DossierId dossierId;
    @Column(name = "soldeRecouvrement")
    private float soldeRecouvrement;
    @Column(name = "etat_CTX")
    private boolean etat_CTX;
    @Column(name="dateTransfert")
    private LocalDate dateTransfert;

    @OneToOne
    @JoinColumn(name = "compte_bancaire_id", referencedColumnName = "numCompte", unique = true)
    private CompteBancaire compteBancaire;
    @OneToOne
    @JoinColumn(name = "Jounral")
    private JournalDebiteur journalDebiteur;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch=FetchType.EAGER)
    private List<Risque> risque;
}
