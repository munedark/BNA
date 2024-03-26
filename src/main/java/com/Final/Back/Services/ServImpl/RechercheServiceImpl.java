package com.Final.Back.Services.ServImpl;

import com.Final.Back.Dto.DebiteurInfo;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.DossierDebiteur.DossierId;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Services.RechercheService;
import com.Final.Back.Services.UtilisateursServ.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public DossierDebiteur rechercher(Long numCtx) {
        DossierDebiteur dossierDebiteur = dossierDebiteurRepo.findById(new DossierId(numCtx, "")).orElse(null);
        if (dossierDebiteur != null) {

            return dossierDebiteur;
        }
        return null;
    }
    }

