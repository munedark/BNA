package com.Final.Back.Operations.GeneralNonAuxiliaire;

import com.Final.Back.Modles.Risques.Risque;

import java.time.LocalDate;
import java.util.List;

public interface OperationNonAuxService {
    OperationNonAux saveOperationNonAux(OperationNonAux OperationNonAux);
    OperationNonAux getOperationNonAuxById(Long id);

    OperationNonAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation, Risque risque);

    void deleteOperationNonAux(Long id);
    List<OperationNonAux> getOperationsSansMatriculeValidateur();
    List<OperationNonAux> getAllOperations();
}
