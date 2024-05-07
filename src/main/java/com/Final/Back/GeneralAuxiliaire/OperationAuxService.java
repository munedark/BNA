package com.Final.Back.GeneralAuxiliaire;

public interface OperationAuxService {
    OperationAux saveOperationAux(OperationAux operationAux);
    OperationAux getOperationAuxById(Long id);
    OperationAux updateOperationAux(Long id, OperationAux updatedOperationAux);
    void deleteOperationAux(Long id);
}
