package com.Final.Back.FraisAuxiliaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraisAuxiliaireServiceImpl implements FraisAuxiliaireService {

    @Autowired
    private FraisAuxiliaireRepo fraisAuxiliaireRepo;

    @Override
    public FraisAuxiliaire saveFraisAuxiliaire(FraisAuxiliaire fraisAuxiliaire) {
        return fraisAuxiliaireRepo.save(fraisAuxiliaire);
    }

    @Override
    public FraisAuxiliaire getFraisAuxiliaireById(Long id) {
        return fraisAuxiliaireRepo.findById(id).orElse(null);
    }

    @Override
    public FraisAuxiliaire updateFraisAuxiliaire(Long id, FraisAuxiliaire updatedFraisAuxiliaire) {
        FraisAuxiliaire existingFraisAuxiliaire = fraisAuxiliaireRepo.findById(id).orElse(null);
        if (existingFraisAuxiliaire != null) {
            existingFraisAuxiliaire.setTypeAuxiliaire(updatedFraisAuxiliaire.getTypeAuxiliaire());
            existingFraisAuxiliaire.setAuxiliaire(updatedFraisAuxiliaire.getAuxiliaire());
            existingFraisAuxiliaire.setCinAuxiliaire(updatedFraisAuxiliaire.getCinAuxiliaire());
            existingFraisAuxiliaire.setNomAuxiliaire(updatedFraisAuxiliaire.getNomAuxiliaire());
            existingFraisAuxiliaire.setMntHonoraire(updatedFraisAuxiliaire.getMntHonoraire());
            existingFraisAuxiliaire.setNatureAuxiliaire(updatedFraisAuxiliaire.getNatureAuxiliaire());
            existingFraisAuxiliaire.setRneAuxiliaire(updatedFraisAuxiliaire.getRneAuxiliaire());
            existingFraisAuxiliaire.setPrenomAuxiliaire(updatedFraisAuxiliaire.getPrenomAuxiliaire());
            existingFraisAuxiliaire.setNumAffaireCTX(updatedFraisAuxiliaire.getNumAffaireCTX());
            existingFraisAuxiliaire.setNomBeneficiairePaiment(updatedFraisAuxiliaire.getNomBeneficiairePaiment());
            // You can update more fields as needed
            return fraisAuxiliaireRepo.save(existingFraisAuxiliaire);
        }
        return null;
    }

    @Override
    public void deleteFraisAuxiliaire(Long id) {
        fraisAuxiliaireRepo.deleteById(id);
    }
}
