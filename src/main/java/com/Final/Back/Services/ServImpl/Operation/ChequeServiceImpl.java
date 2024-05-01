package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.Operation.Cheque;
import com.Final.Back.Repository.Operation.ChequeRepo;
import com.Final.Back.Services.OperationServ.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChequeServiceImpl implements ChequeService {

    @Autowired
    private ChequeRepo chequeRepository;

    @Override
    public Cheque saveCheque(Cheque cheque) {
        return chequeRepository.save(cheque);
    }

    @Override
    public Optional<Cheque> getChequeById(Long id) {
        return chequeRepository.findById(id);

    }

    @Override
    public List<Cheque> getAllCheques() {
        return chequeRepository.findAll();
    }

    @Override
    public void deleteChequeById(Long id) {
        chequeRepository.deleteById(id);
    }
}
