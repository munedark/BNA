package com.Final.Back.Services.OperationServ;

import com.Final.Back.Modles.Operation.OperationCTX;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OperationCTXService {
    List<OperationCTX> getAllOperations();
    Optional<OperationCTX> getOperationById(Long id);
    OperationCTX saveOperation(OperationCTX operation);
    void deleteOperationById(Long id);

    OperationCTX updateOperationCTX(Long id, String matriculeValidateur, Date dateValidation, String etatOperation);
    OperationCTX updateOperationByCheque(Long id, String matriculeValidateur, Date dateValidation, String etatOperation);
    List<OperationCTX> findByLibelleOperation(String libelleOperation);
}
