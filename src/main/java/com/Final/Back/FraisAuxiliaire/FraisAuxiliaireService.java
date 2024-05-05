package com.Final.Back.FraisAuxiliaire;

public interface FraisAuxiliaireService {
    FraisAuxiliaire saveFraisAuxiliaire(FraisAuxiliaire fraisAuxiliaire);
    FraisAuxiliaire getFraisAuxiliaireById(Long id);
    FraisAuxiliaire updateFraisAuxiliaire(Long id, FraisAuxiliaire updatedFraisAuxiliaire);
    void deleteFraisAuxiliaire(Long id);
    // You can add more methods as needed
}
