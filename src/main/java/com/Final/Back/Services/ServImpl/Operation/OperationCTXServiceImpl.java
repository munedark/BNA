package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.Operation.OperationCTX;
import com.Final.Back.Repository.Operation.OperationCTXRepo;
import com.Final.Back.Services.OperationServ.OperationCTXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<OperationCTX> operationsByTypeLibell(String typeLibelle) {
       return operationCTXRepo.findByTypeOperation_LibelleOperation(typeLibelle);

    }


}
