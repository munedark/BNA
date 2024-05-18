package com.Final.Back.Operations.GeneralAuxiliaire;

import java.time.LocalDate;
import java.util.List;

public interface OperationAuxService {
    OperationAux saveOperationAux(OperationAux operationAux);
    OperationAux getOperationAuxById(Long id);
    OperationAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);

    void deleteOperationAux(Long id);
    List<OperationAux> getOperationsSansMatriculeValidateur();
    List<OperationAux> getAllOperations();
}
