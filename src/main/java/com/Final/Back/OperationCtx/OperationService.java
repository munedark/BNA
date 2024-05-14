package com.Final.Back.OperationCtx;

import java.time.LocalDate;
import java.util.List;

public interface OperationService {
    OperationCtx saveOperation(OperationCtx operationCtx);
    OperationCtx getOperationById(Long id);
    void deleteOperation(Long id);

    OperationCtx updateOperationByCheque(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);
    void updateOperationVirement(OperationCtx operation);
    List<OperationCtx> OperationVirementValide();

    List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullVirementTelecomponse();
    List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullCheque();
    List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullFormeAffectation();
    List<OperationCtx> getOperationCheque();
}
