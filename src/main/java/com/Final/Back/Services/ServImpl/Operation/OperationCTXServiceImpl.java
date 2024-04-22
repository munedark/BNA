package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.Operation.OperationCTX;
import com.Final.Back.Repository.Operation.OperationCTXRepo;
import com.Final.Back.Services.OperationServ.OperationCTXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OperationCTXServiceImpl implements OperationCTXService {

    private final OperationCTXRepo operationCTXRepo;

    @Autowired
    public OperationCTXServiceImpl(OperationCTXRepo operationCTXRepo) {
        this.operationCTXRepo = operationCTXRepo;
    }

    @Override
    public List<OperationCTX> getAllOperations() {
        return operationCTXRepo.findAll();
    }

    @Override
    public Optional<OperationCTX> getOperationById(Long id) {
        return operationCTXRepo.findById(id);
    }

    @Override
    public OperationCTX saveOperation(OperationCTX operation) {
        return operationCTXRepo.save(operation);
    }

    @Override
    public void deleteOperationById(Long id) {
        operationCTXRepo.deleteById(id);
    }

    @Override
    public OperationCTX updateOperationCTX(Long id, String matriculeValidateur, Date dateValidation, String etatOperation) {
        OperationCTX operation = operationCTXRepo.findById(id).orElse(null);
        if (operation != null) {
            operation.setMatriculeValidateur(matriculeValidateur);
            operation.setDateValidation(dateValidation);
            operation.setEtatOperation(etatOperation);
            return operationCTXRepo.save(operation);
        }
        return null; // or throw an exception
    }

    @Override
    public List<OperationCTX> findByLibelleOperation(String libelleOperation) {
        return operationCTXRepo.findByTypeOperationLibelleOperation(libelleOperation);
    }



}
