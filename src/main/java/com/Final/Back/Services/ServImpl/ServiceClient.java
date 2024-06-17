package com.Final.Back.Services.ServImpl;

import com.Final.Back.Dto.ClientInfo;
import com.Final.Back.Dto.DebiteurInfo;
import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Modles.Utilisateurs.Client;
import com.Final.Back.Modles.Utilisateurs.Personne;
import com.Final.Back.Repository.Authentification.ProfileRepo;
import com.Final.Back.Repository.CompteBancaire.CompteBancaireRepo;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Repository.Utilisateurs.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceClient {
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    CompteBancaireRepo compteBancaireRepo;
    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;
    @Autowired
    ClientRepo clientRepo;
    public ClientInfo recherecheDossier(String matricule) {
        Profile profile = profileRepo.findByUsername(matricule).orElse(null);
        if (profile != null) {
            Personne personne = profile.getPersonne();
            Client client = clientRepo.findById(personne.getId()).orElse(null);
            if (client != null) {
                List<CompteBancaire> compteBancaire = compteBancaireRepo.findByClient(client);
                if (!compteBancaire.isEmpty()) {
                    DossierDebiteur dossierDebiteur = dossierDebiteurRepo.findByCompteBancaire(compteBancaire.get(0));
                    if (dossierDebiteur != null) {
                        List<Risque> risques = dossierDebiteur.getRisque();
                        ClientInfo clientInfo = new ClientInfo();
                        clientInfo.setDossierDebiteur(dossierDebiteur);
                        clientInfo.setRisques(risques);
                        return clientInfo;
                    }
                }
            }
        }
        return null;
    }

}
