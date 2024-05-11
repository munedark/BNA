package com.Final.Back.OperationCtx;

import com.Final.Back.GeneralNonAuxiliaire.OperationNonAux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepo extends JpaRepository<OperationCtx,Long> {
    @Query("SELECT o FROM OperationCtx o WHERE o.virementTelecomponse.validation = 'validé'")
    List<OperationCtx> findOperationsWithValidatedVirement();
    List<OperationCtx> findByMatriculeValidateurIsNullAndVirementTelecomponseIsNotNull();
    List<OperationCtx> findByMatriculeValidateurIsNullAndChequeIsNotNull();
    List<OperationCtx> findByMatriculeValidateurIsNullAndFormeAffectationIsNotNull();

}
