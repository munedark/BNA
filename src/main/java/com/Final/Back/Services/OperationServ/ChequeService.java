package com.Final.Back.Services.OperationServ;

import com.Final.Back.Modles.Operation.Cheque;

import java.util.List;
import java.util.Optional;

public interface ChequeService {
    Cheque saveCheque(Cheque cheque);
    Optional<Cheque> getChequeById(Long id);
    List<Cheque> getAllCheques();
    void deleteChequeById(Long id);

}
