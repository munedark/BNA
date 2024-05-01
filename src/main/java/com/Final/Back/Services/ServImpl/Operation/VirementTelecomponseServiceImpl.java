package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.Operation.VirementTelecomponse;

import com.Final.Back.Repository.Operation.VirementTelecomponseRepo;
import com.Final.Back.Services.OperationServ.VirementTelecomponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class VirementTelecomponseServiceImpl implements VirementTelecomponseService {

    private final VirementTelecomponseRepo virementRepository;

    @Autowired
    public VirementTelecomponseServiceImpl(VirementTelecomponseRepo virementRepository) {
        this.virementRepository = virementRepository;
    }

    @Override
    public List<VirementTelecomponse> getAllVirements() {
        return virementRepository.findAll();
    }

    @Override
    public VirementTelecomponse getVirementById(Long id) {
        return virementRepository.findById(id).orElse(null);
    }

    @Override
    public List<VirementTelecomponse> getVirementsByDate(LocalDate date) {
        return virementRepository.findByDateOperation(date);
    }

    @Override
    public VirementTelecomponse createVirement(VirementTelecomponse virement) {
        return virementRepository.save(virement);
    }

    @Override
    public void deleteVirement(Long id) {
        virementRepository.deleteById(id);
    }
}
