package com.Final.Back.GeneralAuxiliaire;



import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OperationAuxServieImpl implements OperationAuxService {
    @Autowired
    private OperationAuxRepo operationAuxRepo;
    @Autowired
    private DossierDebiteurRepo dossierDebiteurRepo;

    public OperationAux saveOperationAux(OperationAux OperationAux) {
        return operationAuxRepo.save(OperationAux);
    }


    public OperationAux getOperationAuxById(Long id) {
        return operationAuxRepo.findById(id).orElse(null);
    }


    @Override
    public OperationAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation) {
        OperationAux operation = operationAuxRepo.findById(id).orElse(null);
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


            return operationAuxRepo.save(operation);
        }
        return null;
    }

    public List<OperationAux> getOperationsSansMatriculeValidateur() {
        return operationAuxRepo.findByMatriculeValidateurIsNull();
    }

    public void deleteOperationAux(Long id) {
        operationAuxRepo.deleteById(id);
    }
    public List<OperationAux> getAllOperations() {
        return operationAuxRepo.findAll();
    }
}
