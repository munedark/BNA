package com.Final.Back.Operations.OperationCtx;

import com.Final.Back.Modles.Risques.Risque;

import java.time.LocalDate;
import java.util.List;

public interface OperationService {
    OperationCtx saveOperation(OperationCtx operationCtx);
    OperationCtx getOperationById(Long id);
    void deleteOperation(Long id);

    OperationCtx updateOperationByCheque(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);
    OperationCtx updateOperationByAffectation(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);
    void updateOperationVirement(OperationCtx operation);
    List<OperationCtx> OperationVirementValide();

    List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullVirementTelecomponse();
    List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullCheque();
    List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullFormeAffectation();
    List<OperationCtx> getOperationCheque();
    void clotureDossier(OperationCtx operation);
    void clotureRisque(OperationCtx operation, Risque risque);
}
