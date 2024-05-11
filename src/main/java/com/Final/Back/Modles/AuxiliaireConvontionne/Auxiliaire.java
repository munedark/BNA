package com.Final.Back.Modles.AuxiliaireConvontionne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
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
