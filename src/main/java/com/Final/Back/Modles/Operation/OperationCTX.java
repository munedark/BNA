package com.Final.Back.Modles.Operation;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Modles.Utilisateurs.AgentBna;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "OperationCTX")
public class OperationCTX {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "Operation_id_Sequence")
    @SequenceGenerator(name = "Operation_id_Sequence", sequenceName = "OPERATION_ID_SEQ")
    @Column(name="idOperation",nullable=false,unique=true)
    private Long idOperation;
    @Column(name ="mntOperation")
    private float mntOperation;
    @Column(name ="MntFrais")
    private float mntFrais;
    @Column(name ="typeFrais")
    private String typeFrais;
    @Column(name ="typeAuxiliaire")
    private String typeAuxiliaire;
    @Column(name ="typePiece")
    private String typePiece;
    @Column(name = "numeroPiece")
    private Long numeroPiece;
    @Column(name ="auxiliaire")
    private String auxiliaire;
    @Column(name ="cinAuxiliaire")
    private Long cinAuxiliaire;
    @Column(name ="nomAuxiliaire")
    private String nomAuxiliaire;
    @Column(name ="mntHonoraire")
    private float mntHonoraire;
    @Column(name ="RIB")
    private Long rib;
    @Column(name ="nomBeneficiaire")
    private String nomBeneficiaire;
    @Column(name ="natureAuxiliaire")
    private String natureAuxiliaire;
    @Column(name ="RneAuxiliaire")
    private String rneAuxiliaire;
    @Column(name ="prenomAuxiliaire")
    private String prenomAuxiliaire;
    @Column(name ="dateOperation")
    private Date dateOperation;
    @Column(name ="dateCreation")
    private Date dateCreation;
    @Column(name ="dateValeurCTX")
    private Date dateValeurCTX;
    @Column(name ="matriculeAjout")
    private String matriculeAjout;
    @Column(name ="matriculeValidateur")
    private String matriculeValidateur;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name ="dateValidation")
    private Date dateValidation;
    @Column(name ="etatOperation")
    private String etatOperation;
    @Column(name ="numAffaireCTX")
    private Float numAffaireCTX;
    @Column(name ="nomBeneficiairePaiment")
    private String nomBeneficiairePaiment;
    @Column(name ="matriculeEmploye")
    private String matriculeEmploye;
    @Column(name ="motifOperainoCTX")
    private Float motifOperationCTX;
    @ManyToOne
    @JoinColumn(name = "Operation_id", referencedColumnName = "idType" )
    private TypeOperation typeOperation;
    @OneToOne
    private TypePaiment typePaiments ;
    @ManyToOne
    @JoinColumn(name = "Risque_id", referencedColumnName = "id" )
    private Risque risque;
    @ManyToOne
    private DossierDebiteur dossierDebiteur;
}
