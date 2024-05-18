package com.Final.Back.Operations.OperationFraisGeneraux;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.List;

public interface OperationFraisGenerauxService {
    OperationFraisGeneraux saveOperation(OperationFraisGeneraux operation);
    OperationFraisGeneraux getOperationById(Long id);
    List<OperationFraisGeneraux> getAllOperations();
    void deleteOperation(Long id);
    OperationFraisGeneraux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);

}
