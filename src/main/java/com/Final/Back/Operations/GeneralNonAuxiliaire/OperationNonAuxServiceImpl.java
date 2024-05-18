package com.Final.Back.Operations.GeneralNonAuxiliaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Operations.GeneralAuxiliaire.OperationAux;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
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
    @Autowired
    private RisqueRepo risqueRepo;
    @Override
    public OperationNonAux saveOperationNonAux(OperationNonAux operationNonAux) {
        return operationNonAuxRepo.save(operationNonAux);
    }



    @Override
    public OperationNonAux getOperationNonAuxById(Long id) {
        return operationNonAuxRepo.findById(id).orElse(null);
    }

    @Override
    public OperationNonAux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation,Risque risque) {
        OperationNonAux operation = operationNonAuxRepo.findById(id).orElse(null);
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
