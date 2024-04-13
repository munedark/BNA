package com.Final.Back.Modles.AuxiliaireConvontionne;

import javax.persistence.*;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Huissier {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "huissier_id_Sequence")
    @SequenceGenerator(name = "huissier_id_Sequence", sequenceName = "HUISSIER_ID_SEQ")
    Long huissierId;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "rne")
    String rne;
    @Column(name = "cin" ,unique = true)
    String cin;

}
