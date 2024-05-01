package com.Final.Back.Services.ServImpl.Operation;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Operation.Cheque;
import com.Final.Back.Modles.Operation.OperationCTX;
import com.Final.Back.Modles.Operation.VirementTelecomponse;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Operation.OperationCTXRepo;
import com.Final.Back.Repository.Operation.VirementTelecomponseRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
import com.Final.Back.Services.OperationServ.OperationCTXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OperationCTXServiceImpl implements OperationCTXService {

    private final OperationCTXRepo operationCTXRepo;
    @Autowired
    VirementTelecomponseRepo virementRepository;
    @Autowired
    public OperationCTXServiceImpl(OperationCTXRepo operationCTXRepo) {
        this.operationCTXRepo = operationCTXRepo;
    }
@Autowired
    RisqueRepo risqueRepo;
    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;
    @Override
    public List<OperationCTX> getAllOperations() {
        return operationCTXRepo.findAll();
    }

    @Override
    public Optional<OperationCTX> getOperationById(Long id) {
        return operationCTXRepo.findById(id);
    }

    @Override
    public OperationCTX saveOperation(OperationCTX operation) {
        return operationCTXRepo.save(operation);
    }

    @Override
    public void deleteOperationById(Long id) {
        operationCTXRepo.deleteById(id);
    }

    @Override
    public OperationCTX updateOperationCTX(Long id, String matriculeValidateur, Date dateValidation, String etatOperation) {
        OperationCTX operation = operationCTXRepo.findById(id).orElse(null);
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


            return operationCTXRepo.save(operation);
        }
        return null;
    }
    @Override
    public OperationCTX updateOperationByCheque(Long id, String matriculeValidateur, Date dateValidation, String etatOperation) {
        OperationCTX operation = operationCTXRepo.findById(id).orElse(null);
        if (operation != null) {
            operation.setMatriculeValidateur(matriculeValidateur);
            operation.setDateValidation(dateValidation);
            operation.setEtatOperation(etatOperation);

            DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
            Cheque cheque = operation.getCheque();

            if (cheque != null && etatOperation.equals("V") && dossierDebiteur != null) {
                float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() - cheque.getMntCheque();
                dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);

                dossierDebiteurRepo.save(dossierDebiteur);
            }

            return operationCTXRepo.save(operation);
        }
        return null;
    }
public  void updateOperationVirement(OperationCTX operation){
    operationCTXRepo.save(operation);
    operation.getVirementTelecomponse().setValidation("validé");
    virementRepository.save(operation.getVirementTelecomponse());
    DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
    VirementTelecomponse virementTelecomponse=operation.getVirementTelecomponse();
    float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() - virementTelecomponse.getMontantVirement();
    dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);

    dossierDebiteurRepo.save(dossierDebiteur);

}


    @Override
    public List<OperationCTX> findByLibelleOperation(String libelleOperation) {
        return operationCTXRepo.findByTypeOperationLibelleOperation(libelleOperation);
    }



}
