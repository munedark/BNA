package com.Final.Back.GeneralNonAuxiliaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OperationNonAuxServiceImpl implements OperationNonAuxService {
    @Autowired
    private DossierDebiteurRepo dossierDebiteurRepo;
    @Autowired
    private OperationNonAuxRepo operationNonAuxRepo;

    @Override
    public OperationNonAux saveOperationNonAux(OperationNonAux operationNonAux) {
        return operationNonAuxRepo.save(operationNonAux);
    }



    @Override
    public OperationNonAux getOperationNonAuxById(Long id) {
        return operationNonAuxRepo.findById(id).orElse(null);
    }

    @Override
    public OperationNonAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation) {
        OperationNonAux operation = operationNonAuxRepo.findById(id).orElse(null);
        if (operation != null) {

            operation.setMatriculeValidateur(matriculeValidateur);
            operation.setDateValidation(dateValidation);
            operation.setEtatOperation(etatOperation);

            DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
            if (dossierDebiteur != null && etatOperation.equals("V")) {

                float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() + operation.getMntFrais();
                dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);

                dossierDebiteurRepo.save(dossierDebiteur);
            }


            return operationNonAuxRepo.save(operation);
        }
        return null;
    }
    public List<OperationNonAux> getOperationsSansMatriculeValidateur() {
        return operationNonAuxRepo.findByMatriculeValidateurIsNull();
    }
    @Override
    public void deleteOperationNonAux(Long id) {
        operationNonAuxRepo.deleteById(id);
    }
    public List<OperationNonAux> getAllOperations() {
        return operationNonAuxRepo.findAll();
    }
}
