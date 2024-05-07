package com.Final.Back.Modles.AuxiliaireConvontionne;

import javax.persistence.*;
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Auxiliaire {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "auxiliaire_id_Sequence")
    @SequenceGenerator(name = "auxiliaire_id_Sequence", sequenceName = "AUXILIAIRE_ID_SEQ")
    Long idAuxiliaire;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "rne")
    String rne;
    @Column(name = "cin", unique = true)
    String cin;

}
