package com.Final.Back.Modles.Operation;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Modles.Utilisateurs.AgentBna;
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
    private float mntOpeation;
    @Column(name ="MntFrais")
    private float mntFrais;
    @Column(name ="dateOperation")
    private Date dateOperation;
    @Column(name ="dateCreation")
    private Date dateCreation;
    @Column(name ="matriculeAjout")
    private String matriculeAjout;
    @Column(name ="matriculeValidateur")
    private String matriculeValidateur;
    @Column(name ="dateValidation")
    private Date dateValidation;
    @Column(name ="etatOperation")
    private String etatOperation;
    @Column(name ="numAffaireCTX")
    private Float numAffaireCTX;
    @Column(name ="nomBeneficiairePaiment")
    private String nomBeneficiairePaiment;
    @Column(name ="motifOperainoCTX")
    private Float motifOperationCTX;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TypeOperation> typeOperations;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TypePaiment> typePaiments ;
    @ManyToOne(cascade = CascadeType.ALL)
    private Risque risque;
    @ManyToOne(cascade = CascadeType.ALL)
    private DossierDebiteur dossierDebiteur;
}
