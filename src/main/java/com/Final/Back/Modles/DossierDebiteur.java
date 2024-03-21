package com.Final.Back.Modles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class DossierDebiteur {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "dossier_id_Sequence")
    @SequenceGenerator(name = "dossier_id_Sequence", sequenceName = "DOSSIER_ID_SEQ")
    private Long id;
    @Column(name = "soldeRecouvrement")
    private float soldeRecouvrement;
    @Column(name = "etat_CTX")
    private boolean etat_CTX;
    @Column(name="dateTransfert")
    private Date dateTransfert;

    @OneToOne
    @JoinColumn(name = "compte_bancaire_id", referencedColumnName = "numCompte", unique = true)
    private CompteBancaire compteBancaire;
}
