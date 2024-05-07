package com.Final.Back.GeneralNonAuxiliaire;

import java.util.List;

public interface OperationNonAuxService {
    OperationNonAux saveOperationNonAux(OperationNonAux OperationNonAux);
    OperationNonAux getOperationNonAuxById(Long id);
    List<OperationNonAux> getAllOperationNonAux();
    OperationNonAux updateOperationNonAux(Long id, OperationNonAux updatedOperationNonAux);
    void deleteOperationNonAux(Long id);
}
