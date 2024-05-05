package com.Final.Back.OperationCtx;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Operation.*;
import com.Final.Back.Modles.Risques.Risque;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "OperationCtx")
public class OperationCtx {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "OperationCtx_id_Sequence")
    @SequenceGenerator(name = "OperationCtx_id_Sequence", sequenceName = "OPERATIONCTX_ID_SEQ")
    @Column(name="idOperation",nullable=false,unique=true)
    private Long idOperationCtx;
    @Column(name ="dateOperation")
    private LocalDate dateOperation;
    @Column(name ="dateAjout")
    private LocalDate dateAjout;
    @Column(name ="matriculeAjout")
    private String matriculeAjout;
    @Column(name ="matriculeValidateur")
    private String matriculeValidateur;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name ="dateValidation")
    private LocalDate dateValidation;
    @Column(name ="etatOperation")
    private String etatOperation;
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
    @OneToOne
    private Cheque cheque;
    @OneToOne
    private VirementTelecomponse virementTelecomponse;
    @OneToOne
    private FormeAffectation formeAffectation;

}

