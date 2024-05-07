package com.Final.Back.GeneralNonAuxiliaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OperationNonAuxSerivceImpl implements OperationNonAuxService {

    @Autowired
    private OperationNonAuxRepo operationNonAuxRepo;

    @Override
    public OperationNonAux saveOperationNonAux(OperationNonAux operationNonAux) {
        return operationNonAuxRepo.save(operationNonAux);
    }


    @Override
    public List<OperationNonAux> getAllOperationNonAux() {
        return operationNonAuxRepo.findAll();
    }
    @Override
    public OperationNonAux getOperationNonAuxById(Long id) {
        return operationNonAuxRepo.findById(id).orElse(null);
    }

    @Override
    public OperationNonAux updateOperationNonAux(Long id, OperationNonAux updatedOperationNonAux) {
        OperationNonAux existingOperationNonAux = operationNonAuxRepo.findById(id).orElse(null);
        if (existingOperationNonAux != null) {
            existingOperationNonAux.setTypePiece(updatedOperationNonAux.getTypePiece());
            existingOperationNonAux.setNumeroPiece(updatedOperationNonAux.getNumeroPiece());
            // You can update more fields as needed
            return operationNonAuxRepo.save(existingOperationNonAux);
        }
        return null;
    }

    @Override
    public void deleteOperationNonAux(Long id) {
        operationNonAuxRepo.deleteById(id);
    }
}
