package com.Final.Back.Modles.Operation;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class FormeAffectation {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "affectation_id_Sequence")
    @SequenceGenerator(name = "affectation_id_Sequence", sequenceName = "AFFECTATION_ID_SEQ")
    @Column(name="idAffectation",nullable=false,unique=true)
    private Long idAffectation;
    String typeRecouvrement;
    float mntAffectationPrincipale;
    float mntFrais;
    LocalDate dateAffectation;


}
