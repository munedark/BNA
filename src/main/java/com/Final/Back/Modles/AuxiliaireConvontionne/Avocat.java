package com.Final.Back.Modles.AuxiliaireConvontionne;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Avocat {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "avocat_id_Sequence")
    @SequenceGenerator(name = "avocat_id_Sequence", sequenceName = "AVOCAT_ID_SEQ")
    Long avocatId;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "rne")
    String rne;
    @Column(name = "cin", unique = true)
    String cin;

}
