package com.Final.Back.OperationCtx;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Operation.Cheque;
import com.Final.Back.Modles.Operation.VirementTelecomponse;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Operation.VirementTelecomponseRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationRepo operationRepo;
    @Autowired
    VirementTelecomponseRepo virementRepository;
    @Autowired
    RisqueRepo risqueRepo;
    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;

    @Override
    public OperationCtx saveOperation(OperationCtx operationCtx) {
        return operationRepo.save(operationCtx);
    }

    @Override
    public OperationCtx getOperationById(Long id) {
        return operationRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteOperation(Long id) {
        operationRepo.deleteById(id);
    }

    @Override
    public OperationCtx updateOperationByCheque(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation) {
        OperationCtx operation = operationRepo.findById(id).orElse(null);
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

            return operationRepo.save(operation);
        }
        return null;
    }

    public  void updateOperationVirement(OperationCtx operation){
        operationRepo.save(operation);
        operation.getVirementTelecomponse().setValidation("validé");
        virementRepository.save(operation.getVirementTelecomponse());
        DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
        VirementTelecomponse virementTelecomponse=operation.getVirementTelecomponse();
        float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() - virementTelecomponse.getMontantVirement();
        dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);

        dossierDebiteurRepo.save(dossierDebiteur);

    }

    @Override
    public List<OperationCtx> OperationVirementValide() {
        return operationRepo.findOperationsWithValidatedVirement();
    }




}
