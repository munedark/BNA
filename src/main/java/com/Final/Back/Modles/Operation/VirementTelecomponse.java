package com.Final.Back.Modles.Operation;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class VirementTelecomponse {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "virement_id_Sequence")
    @SequenceGenerator(name = "virement_id_Sequence", sequenceName = "VIREMENT_ID_SEQ")
    @Column(name="idVirement",nullable=false,unique=true)
    private Long idVirement;
    @Column(name="numVirement")
    int numVirement;
    @Column(name="dateOperation")
    LocalDate dateOperation;
    @Column(name="nomBeneficiaire")
    String nomBeneficiaire;
    @Column(name="ribBeneficiaire")
    String ribBeneficiaire;
    @Column(name="mntVirement")
    float montantVirement;
    @Column(name="motif")
    String motif;
    @Column(name="nomDonneur")
    String nomDonneur;
    @Column(name="ribDonneur")
    String ribDonneur;
    @Column(name="Validation")
    String validation;
}
