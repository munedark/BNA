package com.Final.Back.Operations.GeneralAuxiliaire;

import com.Final.Back.Modles.AuxiliaireConvontionne.Auxiliaire;
import com.Final.Back.Operations.OperationFraisGeneraux.OperationFraisGeneraux;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class OperationAux extends OperationFraisGeneraux {

    @Column(name ="typeAuxiliaire")
    private String typeAuxiliaire;
    @Column(name ="cinAuxiliaire")
    private Long cinAuxiliaire;
    @Column(name ="nomAuxiliaire")
    private String nomAuxiliaire;
    @Column(name ="mntHonoraire")
    private float mntHonoraire;
    @Column(name ="natureAuxiliaire")
    private String natureAuxiliaire;
    @Column(name ="RneAuxiliaire")
    private String rneAuxiliaire;
    @Column(name ="prenomAuxiliaire")
    private String prenomAuxiliaire;
    @Column(name ="numAffaireCTX")
    private Float numAffaireCTX;
    @ManyToOne
    private Auxiliaire auxiliaire;

}
