package com.Final.Back.OperationFraisGeneraux;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public interface OperationFraisGenerauxService {
    OperationFraisGeneraux saveOperation(OperationFraisGeneraux operation);
    OperationFraisGeneraux getOperationById(Long id);

    void deleteOperation(Long id);
    OperationFraisGeneraux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);

}
