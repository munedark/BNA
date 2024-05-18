package com.Final.Back.Operations.OperationCtx;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Operation.Cheque;
import com.Final.Back.Modles.Operation.FormeAffectation;
import com.Final.Back.Modles.Operation.VirementTelecomponse;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Operation.VirementTelecomponseRepo;
import com.Final.Back.Repository.Risque.RisqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    private final OperationRepo operationRepo;
    private final VirementTelecomponseRepo virementRepository;
    private final RisqueRepo risqueRepo;
    private final DossierDebiteurRepo dossierDebiteurRepo;

    @Autowired
    public OperationServiceImpl(OperationRepo operationRepo, VirementTelecomponseRepo virementRepository, RisqueRepo risqueRepo, DossierDebiteurRepo dossierDebiteurRepo) {
        this.operationRepo = operationRepo;
        this.virementRepository = virementRepository;
        this.risqueRepo = risqueRepo;
        this.dossierDebiteurRepo = dossierDebiteurRepo;
    }

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

            if (cheque != null && "V".equals(etatOperation) && dossierDebiteur != null) {
                float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() + cheque.getMntCheque();
                dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);

                dossierDebiteurRepo.save(dossierDebiteur);
            }

            return operationRepo.save(operation);
        }
        return null;
    }

    @Override
    public OperationCtx updateOperationByAffectation(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation) {
        OperationCtx operation = operationRepo.findById(id).orElse(null);
        if (operation != null) {
            operation.setMatriculeValidateur(matriculeValidateur);
            operation.setDateValidation(dateValidation);
            operation.setEtatOperation(etatOperation);

            DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
            Risque risque = operation.getRisque();
            FormeAffectation affectation = operation.getFormeAffectation();

            if (affectation != null && "V".equals(etatOperation) && dossierDebiteur != null) {
                float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() - affectation.getMntAffectationPrincipale();
                dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);

                dossierDebiteurRepo.save(dossierDebiteur);
            }

            if (affectation != null && risque != null && etatOperation.equals("V")) {
                float newMntEntreePrincipale = risque.getMntEntreePrincipale() - affectation.getMntAffectationPrincipale();
                if (newMntEntreePrincipale<0){
                    newMntEntreePrincipale=0;
                    float ir=risque.getIr();
                    float newIR=ir-(affectation.getMntAffectationPrincipale()-risque.getMntEntreePrincipale());
                    if(newIR>=0){risque.setIr(newIR);}
                    if(newIR<0){
                        risque.setIr(0);
                        float ic=risque.getIc();
                        float newIC=ic-((affectation.getMntAffectationPrincipale()-risque.getMntEntreePrincipale())-ir);
                        if(newIC<0){
                            risque.setIc(0);
                        }
                        if(newIC>=0){
                            risque.setIc(newIC);
                        }
                    }
                }

                if(risque.getMntFrais()<0){
                    risque.setMntFrais(0);
                }
                if(risque.getIr()==0 && risque.getMntEntreePrincipale()==0 && risque.getIc()==0){
                    risque.setStade("4- Cloturé");
                }


                risque.setMntEntreePrincipale(newMntEntreePrincipale);

                risqueRepo.save(risque);
            }

            return operationRepo.save(operation);
        }
        return null;
    }


    @Transactional
    public void updateOperationVirement(OperationCtx operation) {
        operationRepo.save(operation);
        operation.getVirementTelecomponse().setValidation("validé");
        virementRepository.save(operation.getVirementTelecomponse());

        DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
        VirementTelecomponse virementTelecomponse = operation.getVirementTelecomponse();
        if (dossierDebiteur != null && virementTelecomponse != null) {
            float newSoldeRecouvrement = dossierDebiteur.getSoldeRecouvrement() + virementTelecomponse.getMontantVirement();
            dossierDebiteur.setSoldeRecouvrement(newSoldeRecouvrement);
            dossierDebiteurRepo.save(dossierDebiteur);
        }
    }

    @Override
    public List<OperationCtx> OperationVirementValide() {
        return operationRepo.findOperationsWithValidatedVirement();
    }

    @Override
    public List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullVirementTelecomponse() {
        return operationRepo.findByMatriculeValidateurIsNullAndVirementTelecomponseIsNotNull();
    }

    @Override
    public List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullCheque() {
        return operationRepo.findByMatriculeValidateurIsNullAndChequeIsNotNull();
    }

    @Override
    public List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullFormeAffectation() {
        return operationRepo.findByMatriculeValidateurIsNullAndFormeAffectationIsNotNull();
    }

    @Override
    public List<OperationCtx> getOperationCheque() {
        return operationRepo.findByChequeIsNotNull();
    }

    @Override
    public void clotureDossier(OperationCtx operation) {
        operationRepo.save(operation);

        DossierDebiteur dossierDebiteur = operation.getDossierDebiteur();
        Boolean risqueNonCloture=false;
        for (Risque risque : dossierDebiteur.getRisque()) {
            if (risque.getStade()!="4- Cloturé"){risqueNonCloture=true;}
        }
        if (dossierDebiteur.getSoldeRecouvrement()==0 && risqueNonCloture==false)   {
            dossierDebiteur.setEtat_CTX(false);
            dossierDebiteurRepo.save(dossierDebiteur);
        }
    }


    public void clotureRisque(OperationCtx operation,Risque risque,String typeCloture) {
        operationRepo.save(operation);
        if (risque.getStade()=="4- Cloturé" && risque.getMntEntreePrincipale()==0 && risque.getIr()==0 && risque.getIc()==0)
        {
            risque.setTypeCloture(typeCloture);
        }
        risqueRepo.save(risque);

    }

}
