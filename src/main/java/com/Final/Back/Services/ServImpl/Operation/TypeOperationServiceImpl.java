package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.Operation.TypeOperation;
import com.Final.Back.Repository.Operation.TypeOperationRepo;
import com.Final.Back.Services.OperationServ.TypeOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOperationServiceImpl implements TypeOperationService {

    private final TypeOperationRepo typeOperationRepo;

    @Autowired
    public TypeOperationServiceImpl(TypeOperationRepo typeOperationRepo) {
        this.typeOperationRepo = typeOperationRepo;
    }

    @Override
    public List<TypeOperation> getAllTypeOperations() {
        return typeOperationRepo.findAll();
    }

    @Override
    public Optional<TypeOperation> getTypeOperationById(int id) {
        return typeOperationRepo.findById(id);
    }

    @Override
    public Optional<TypeOperation> getTypeOperationBylibelle(String libelle) {
        return typeOperationRepo.findByLibelleOperation(libelle);
    }
    @Override
    public Optional<TypeOperation> getTypeOperationByNumero(String numero) {
        return typeOperationRepo.findByNumeroType(numero);
    }

    @Override
    public TypeOperation saveTypeOperation(TypeOperation typeOperation) {
        return typeOperationRepo.save(typeOperation);
    }

    @Override
    public void deleteTypeOperationById(int id) {
        typeOperationRepo.deleteById(id);
    }
}
