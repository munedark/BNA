package com.Final.Back.Operations.OperationJugement;

import java.time.LocalDate;
import java.util.List;

public interface OperationFraisJugementService {
    OperationFraisJugement saveOperationFraisJugement(OperationFraisJugement operationFraisJugement);
    OperationFraisJugement getOperationFraisJugementById(Long id);
    OperationFraisJugement updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);
    void deleteOperationFraisJugement(Long id);
    List<OperationFraisJugement> getOperationsSansMatriculeValidateur();
    List<OperationFraisJugement> findAll();

}
