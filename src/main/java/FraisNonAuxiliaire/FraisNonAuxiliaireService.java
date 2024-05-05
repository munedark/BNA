package FraisNonAuxiliaire;

public interface FraisNonAuxiliaireService {
    FraisNonAuxiliaire saveFraisNonAuxiliaire(FraisNonAuxiliaire fraisNonAuxiliaire);
    FraisNonAuxiliaire getFraisNonAuxiliaireById(Long id);
    FraisNonAuxiliaire updateFraisNonAuxiliaire(Long id, FraisNonAuxiliaire updatedFraisNonAuxiliaire);
    void deleteFraisNonAuxiliaire(Long id);
    // You can add more methods as needed
}
