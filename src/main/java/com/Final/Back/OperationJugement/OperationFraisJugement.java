package com.Final.Back.OperationJugement;

import com.Final.Back.OperationCtx.OperationCtx;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class OperationFraisJugement extends OperationCtx {

    @Column(name ="MntFrais")
    private float mntFrais;

    @Column(name ="nomBeneficiaire")
    private String nomBeneficiaire;
    @Column(name ="dateValeurCTX")
    private LocalDate dateValeurCTX;
    @Column(name ="numAffaireCTX")
    private Float numAffaireCTX;
    @Column(name ="nomBeneficiairePaiment")
    private String nomBeneficiairePaiment;
    @Column(name ="motifOperainoCTX")
    private Float motifOperationCTX;
}
