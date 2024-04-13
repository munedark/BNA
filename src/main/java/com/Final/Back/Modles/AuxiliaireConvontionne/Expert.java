package com.Final.Back.Modles.AuxiliaireConvontionne;

import javax.persistence.*;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Expert {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "expert_id_Sequence")
    @SequenceGenerator(name = "expert_id_Sequence", sequenceName = "EXPERT_ID_SEQ")
    Long expertId;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "rne")
    String rne;
    @Column(name = "cin" , unique = true)
    String cin;

}
