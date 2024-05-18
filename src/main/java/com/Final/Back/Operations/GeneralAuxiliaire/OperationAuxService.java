package com.Final.Back.Operations.GeneralAuxiliaire;

import com.Final.Back.Modles.Risques.Risque;

import java.time.LocalDate;
import java.util.List;

public interface OperationAuxService {
    OperationAux saveOperationAux(OperationAux operationAux);
    OperationAux getOperationAuxById(Long id);
    OperationAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation, Risque risque);

    void deleteOperationAux(Long id);
    List<OperationAux> getOperationsSansMatriculeValidateur();
    List<OperationAux> getAllOperations();
}
