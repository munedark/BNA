package com.Final.Back.OperationJugement;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OperationFraisJugementServiceImpl implements OperationFraisJugementService {

    @Autowired
    private OperationFraisJugementRepo operationFraisJugementRepo;
    @Autowired
    RisqueRepo risqueRepo;
    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;

    @Override
    public OperationFraisJugement saveOperationFraisJugement(OperationFraisJugement operationFraisJugement) {
        return operationFraisJugementRepo.save(operationFraisJugement);
    }

    @Override
    public OperationFraisJugement getOperationFraisJugementById(Long id) {
        return operationFraisJugementRepo.findById(id).orElse(null);
    }

    @Override
    public OperationFraisJugement updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation) {
            OperationFraisJugement operation = operationFraisJugementRepo.findById(id).orElse(null);
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


                return operationFraisJugementRepo.save(operation);
            }
            return null;
        }

    public List<OperationFraisJugement> getOperationsSansMatriculeValidateur() {
        return operationFraisJugementRepo.findByMatriculeValidateurIsNull();
    }
    public List<OperationFraisJugement> findAll() {
        return operationFraisJugementRepo.findAll();
    }

    @Override
    public void deleteOperationFraisJugement(Long id) {
        operationFraisJugementRepo.deleteById(id);
    }
}
