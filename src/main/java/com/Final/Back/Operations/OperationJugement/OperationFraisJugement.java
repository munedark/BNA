package com.Final.Back.Operations.OperationJugement;

import com.Final.Back.Operations.OperationCtx.OperationCtx;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "OperationFraisJugement")
public class OperationFraisJugement extends OperationCtx {

    @Column(name ="MntFrais")
    private float mntFrais;
    @Column(name ="dateValeurCTX")
    private LocalDate dateValeurCTX;
    @Column(name ="numAffaireCTX")
    private Long numAffaireCTX;
    @Column(name ="recette")
    private String recette;
    @Column(name ="motifOperainoCTX")
    private float motifOperationCTX;
}
