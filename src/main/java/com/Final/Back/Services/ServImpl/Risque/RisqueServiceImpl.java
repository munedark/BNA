package com.Final.Back.Services.ServImpl.Risque;

import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.Risque.RisqueRepo;
import com.Final.Back.Services.RisqueServ.RisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RisqueServiceImpl implements RisqueService {

    private final RisqueRepo risqueRepo;

    @Autowired
    public RisqueServiceImpl(RisqueRepo risqueRepo) {
        this.risqueRepo = risqueRepo;
    }

    @Override
    public List<Risque> getAllRisques() {
        return risqueRepo.findAll();
    }

    @Override
    public Optional<Risque> getRisqueById(Long id) {
        return risqueRepo.findById(id);
    }

    @Override
    public Risque saveRisque(Risque risque) {
        return risqueRepo.save(risque);
    }

    @Override
    public void deleteRisqueById(Long id) {
        risqueRepo.deleteById(id);
    }
    @Override
    public List<Risque> getRisquesWithZeroSoldeIrIc() {
        return risqueRepo.findBySoldePrincipaleRisqueAndIrAndIc(0, 0, 0);
    }
}
