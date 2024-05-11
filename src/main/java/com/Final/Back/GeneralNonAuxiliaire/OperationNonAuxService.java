package com.Final.Back.GeneralNonAuxiliaire;

import java.time.LocalDate;
import java.util.List;

public interface OperationNonAuxService {
    OperationNonAux saveOperationNonAux(OperationNonAux OperationNonAux);
    OperationNonAux getOperationNonAuxById(Long id);
    List<OperationNonAux> getAllOperationNonAux();
    OperationNonAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);

    void deleteOperationNonAux(Long id);
    List<OperationNonAux> getOperationsSansMatriculeValidateur();
}
