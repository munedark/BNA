package com.Final.Back.Services.ServImpl.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.AgenceBank;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Repository.CompteBancaire.AgenceBankRepo;
import com.Final.Back.Repository.CompteBancaire.CompteBancaireRepo;
import com.Final.Back.Services.CompteBancaireServ.CompteBancaireServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteBancaireImpl implements CompteBancaireServ {

    @Autowired
    CompteBancaireRepo compteBancaireRepo;

    @Override
    public CompteBancaire addCompteBancaire(CompteBancaire compteBancaire) {
        return compteBancaireRepo.save(compteBancaire);
    }

    @Override
    public CompteBancaire getCompteBancaireById(Long id) {
        return compteBancaireRepo.findById(id).orElse(null);
    }

    @Override
    public List<CompteBancaire> getAllComptesBancaires() {
        return compteBancaireRepo.findAll();
    }

    @Override
    public CompteBancaire updateCompteBancaire(CompteBancaire compteBancaire) {
        // Perform update logic, if needed
        return compteBancaireRepo.save(compteBancaire);
    }

    @Override
    public void deleteCompteBancaire(Long id) {
        compteBancaireRepo.deleteById(id);
    }


    @Autowired
    private AgenceBankRepo agenceBankRepo;

    public void addCompteBancaireToAgenceBank(Long compteBancaireId, Long agenceBankId) {
        // Step 1: Retrieve the CompteBancaire entity
        CompteBancaire compteBancaire = compteBancaireRepo.findById(compteBancaireId)
                .orElseThrow(() -> new RuntimeException("CompteBancaire not found with id: " + compteBancaireId));

        // Step 2: Retrieve the AgenceBank entity
        AgenceBank agenceBank = agenceBankRepo.findById(agenceBankId)
                .orElseThrow(() -> new RuntimeException("AgenceBank not found with id: " + agenceBankId));

        compteBancaire.setAgenceBank(agenceBank);

        compteBancaireRepo.save(compteBancaire);
    }
}
