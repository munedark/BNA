package FraisNonAuxiliaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraisNonAuxiliaireServiceImpl implements FraisNonAuxiliaireService {

    @Autowired
    private FraisNonAuxiliaireRepo fraisNonAuxiliaireRepo;

    @Override
    public FraisNonAuxiliaire saveFraisNonAuxiliaire(FraisNonAuxiliaire fraisNonAuxiliaire) {
        return fraisNonAuxiliaireRepo.save(fraisNonAuxiliaire);
    }

    @Override
    public FraisNonAuxiliaire getFraisNonAuxiliaireById(Long id) {
        return fraisNonAuxiliaireRepo.findById(id).orElse(null);
    }

    @Override
    public FraisNonAuxiliaire updateFraisNonAuxiliaire(Long id, FraisNonAuxiliaire updatedFraisNonAuxiliaire) {
        FraisNonAuxiliaire existingFraisNonAuxiliaire = fraisNonAuxiliaireRepo.findById(id).orElse(null);
        if (existingFraisNonAuxiliaire != null) {
            existingFraisNonAuxiliaire.setTypePiece(updatedFraisNonAuxiliaire.getTypePiece());
            existingFraisNonAuxiliaire.setNumeroPiece(updatedFraisNonAuxiliaire.getNumeroPiece());
            // You can update more fields as needed
            return fraisNonAuxiliaireRepo.save(existingFraisNonAuxiliaire);
        }
        return null;
    }

    @Override
    public void deleteFraisNonAuxiliaire(Long id) {
        fraisNonAuxiliaireRepo.deleteById(id);
    }
}
