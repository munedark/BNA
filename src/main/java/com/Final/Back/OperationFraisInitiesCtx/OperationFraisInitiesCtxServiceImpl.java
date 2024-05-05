package com.Final.Back.OperationFraisInitiesCtx;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.OperationFraisGeneraux.OperationFraisGenerauxRepo;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OperationFraisInitiesCtxServiceImpl implements OperationFraisInitiesCtxService {

    @Autowired
    private OperationFraisInitiesCtxRepo operationFraisInitiesCtxRepo;
    @Autowired
    RisqueRepo risqueRepo;
    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;
    @Autowired
    private OperationFraisGenerauxRepo operationFraisGenerauxRepo;

    @Override
    public OperationFraisInitiesCTX saveOperation(OperationFraisInitiesCTX operation) {
        return operationFraisInitiesCtxRepo.save(operation);
    }

    @Override
    public OperationFraisInitiesCTX getOperationById(Long id) {
        return operationFraisInitiesCtxRepo.findById(id).orElse(null);
    }

    @Override
    public OperationFraisInitiesCTX updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation) {
        OperationFraisInitiesCTX operation = operationFraisInitiesCtxRepo.findById(id).orElse(null);
        if (operation != null) {

            operation.setMatriculeValidateur(matriculeValidateur);
            operation.setDateValidation(dateValidation);
            operation.setEtatOperation(etatOperation);


            Risque risque = operation.getRisque();
            if (risque != null && etatOperation.equals("V")) {
                float newMntFrais = risque.getMntFrais() + operation.getMntFrais();
                float newMntEntreePrincipale = risque.getMntEntreePrincipale() + operation.getMntFrais();
                risque.setMntFrais(newMntFrais);
                risque.setMntEntreePrincipale(newMntEntreePrincipale);

                risqueRepo.save(risque);
            }


            DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
            if (dossierDebiteur != null && etatOperation.equals("V")) {

                float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() + operation.getMntFrais();
                dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);

                dossierDebiteurRepo.save(dossierDebiteur);
            }


            return operationFraisInitiesCtxRepo.save(operation);
        }
        return null;
    }

    @Override
    public void deleteOperation(Long id) {
        operationFraisInitiesCtxRepo.deleteById(id);
    }
}
