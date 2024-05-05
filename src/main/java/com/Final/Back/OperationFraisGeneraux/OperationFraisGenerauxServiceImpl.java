package com.Final.Back.OperationFraisGeneraux;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Operation.VirementTelecomponseRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OperationFraisGenerauxServiceImpl implements OperationFraisGenerauxService {

    @Autowired
    private OperationFraisGenerauxRepo operationFraisGenerauxRepo;

    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;

    @Override
    public OperationFraisGeneraux saveOperation(OperationFraisGeneraux operation) {
        return operationFraisGenerauxRepo.save(operation);
    }

    @Override
    public OperationFraisGeneraux getOperationById(Long id) {
        return operationFraisGenerauxRepo.findById(id).orElse(null);
    }



    @Override
    public void deleteOperation(Long id) {
        operationFraisGenerauxRepo.deleteById(id);
    }

    @Override
    public OperationFraisGeneraux updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation) {
        OperationFraisGeneraux operation = operationFraisGenerauxRepo.findById(id).orElse(null);
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


            return operationFraisGenerauxRepo.save(operation);
        }
        return null;
    }
}
