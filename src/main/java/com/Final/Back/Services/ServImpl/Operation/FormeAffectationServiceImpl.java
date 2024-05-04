package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.Operation.FormeAffectation;
import com.Final.Back.Repository.Operation.FormeAffectationRepo;
import com.Final.Back.Services.OperationServ.FormeAffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormeAffectationServiceImpl implements FormeAffectationService {

    @Autowired
    private FormeAffectationRepo formeAffectationRepo;

    @Override
    public List<FormeAffectation> getAllFormeAffectations() {
        return formeAffectationRepo.findAll();
    }

    @Override
    public FormeAffectation getFormeAffectationById(Long id) {
        Optional<FormeAffectation> formeAffectationOptional = formeAffectationRepo.findById(id);
        return formeAffectationOptional.orElse(null);
    }

    @Override
    public FormeAffectation createFormeAffectation(FormeAffectation formeAffectation) {
        return formeAffectationRepo.save(formeAffectation);
    }

    @Override
    public FormeAffectation updateFormeAffectation(Long id, FormeAffectation formeAffectation) {
        if (formeAffectationRepo.existsById(id)) {
            formeAffectation.setIdAffectation(id);
            return formeAffectationRepo.save(formeAffectation);
        } else {
            return null; // or throw exception
        }
    }

    @Override
    public void deleteFormeAffectation(Long id) {
        formeAffectationRepo.deleteById(id);
    }
}