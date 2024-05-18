package com.Final.Back.Operations.GeneralAuxiliaire;



import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
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
    @Autowired
    private RisqueRepo risqueRepo;

    public OperationAux saveOperationAux(OperationAux OperationAux) {
        return operationAuxRepo.save(OperationAux);
    }


    public OperationAux getOperationAuxById(Long id) {
        return operationAuxRepo.findById(id).orElse(null);
    }


    @Override
    public OperationAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation, Risque risque) {
        OperationAux operation = operationAuxRepo.findById(id).orElse(null);
        if (operation != null) {

            operation.setMatriculeValidateur(matriculeValidateur);
            operation.setDateValidation(dateValidation);
            operation.setEtatOperation(etatOperation);


            if (risque != null && etatOperation.equals("V")) {

                float newMntFrais = risque.getMntFrais() + operation.getMntFrais();
                float newSoldePrincipaleRisque = risque.getSoldePrincipaleRisque() + operation.getMntFrais();
                risque.setMntFrais(newMntFrais);
                risque.setSoldePrincipaleRisque(newSoldePrincipaleRisque);

                risqueRepo.save(risque);
            }
            operation.setRisque(risque);


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
