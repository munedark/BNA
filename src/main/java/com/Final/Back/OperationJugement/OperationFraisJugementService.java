package com.Final.Back.OperationJugement;

import java.time.LocalDate;

public interface OperationFraisJugementService {
    OperationFraisJugement saveOperationFraisJugement(OperationFraisJugement operationFraisJugement);
    OperationFraisJugement getOperationFraisJugementById(Long id);
    OperationFraisJugement updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);
    void deleteOperationFraisJugement(Long id);

}
