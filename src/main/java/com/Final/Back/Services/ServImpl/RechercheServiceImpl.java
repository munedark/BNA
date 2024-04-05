package com.Final.Back.Services.ServImpl;

import com.Final.Back.Dto.DebiteurInfo;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.DossierDebiteur.DossierId;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Services.RechercheService;
import com.Final.Back.Services.UtilisateursServ.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class RechercheServiceImpl implements RechercheService {
    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;
    @Autowired
    ClientServ clientService;
    @Override
    public DebiteurInfo recherche(Long num) {
        DossierDebiteur dossierDebiteur = dossierDebiteurRepo.findByNumCtx(num);

        if (dossierDebiteur != null) {
            float numCtx = dossierDebiteur.getDossierId().getNumCtx();
            String nom = dossierDebiteur.getCompteBancaire().getClient().getNom();
            String prenom = dossierDebiteur.getCompteBancaire().getClient().getPrenom();
            boolean etat_CTX = dossierDebiteur.isEtat_CTX();
            Date dateTransfert = dossierDebiteur.getDateTransfert();
            float soldeRecouvrement = dossierDebiteur.getSoldeRecouvrement();

            return new DebiteurInfo(numCtx,nom, prenom, etat_CTX, dateTransfert, soldeRecouvrement);
        }
        return null;
    }


    public List<Risque> Risques(Long numCtx){
        DossierDebiteur dossierDebiteur = dossierDebiteurRepo.findByNumCtx(numCtx);
        if (dossierDebiteur != null) {
            System.out.println("DossierDebiteur retrieved: " + dossierDebiteur); // Log retrieved object
            System.out.println("Number of Risques: " + dossierDebiteur.getRisque().size()); // Log list size

            // Access elements (optional, for lazy loading)
            for (Risque risque : dossierDebiteur.getRisque()) {
                System.out.println(risque.toString());
            }

            return dossierDebiteur.getRisque() != null ? dossierDebiteur.getRisque() : Collections.emptyList();
        }
        return null;
    }




}

