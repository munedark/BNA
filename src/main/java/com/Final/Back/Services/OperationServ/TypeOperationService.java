package com.Final.Back.Services.OperationServ;

import com.Final.Back.Modles.Operation.TypeOperation;

import java.util.List;
import java.util.Optional;

public interface TypeOperationService {
    List<TypeOperation> getAllTypeOperations();
    Optional<TypeOperation> getTypeOperationById(int id);
    Optional<TypeOperation> getTypeOperationBylibelle(String libelle);
    TypeOperation saveTypeOperation(TypeOperation typeOperation);
    void deleteTypeOperationById(int id);
}
