package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.Operation.TypePaiment;
import com.Final.Back.Repository.Operation.TypePaimentRepo;
import com.Final.Back.Services.OperationServ.TypePaimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypePaimentServiceImpl implements TypePaimentService {

    private final TypePaimentRepo typePaimentRepo;

    @Autowired
    public TypePaimentServiceImpl(TypePaimentRepo typePaimentRepo) {
        this.typePaimentRepo = typePaimentRepo;
    }

    @Override
    public List<TypePaiment> getAllTypePaiments() {
        return typePaimentRepo.findAll();
    }

    @Override
    public Optional<TypePaiment> getTypePaimentById(Long id) {
        return typePaimentRepo.findById(id);
    }

    @Override
    public TypePaiment saveTypePaiment(TypePaiment typePaiment) {
        return typePaimentRepo.save(typePaiment);
    }

    @Override
    public void deleteTypePaimentById(Long id) {
        typePaimentRepo.deleteById(id);
    }
}
