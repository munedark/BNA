package com.Final.Back.Services.ServImpl.DossierDebiteur;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.DossierDebiteur.DossierId;
import com.Final.Back.Repository.DossierDebiteur.DossierDebiteurRepo;
import com.Final.Back.Services.DossierDebiteurServ.DossierDebiteurServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierDebiteurImpl implements DossierDebiteurServ {
    @Autowired
    DossierDebiteurRepo dossierDebiteurRepo;
    @Override
    public List<DossierDebiteur> getAllDossierDebiteurs() {
        return dossierDebiteurRepo.findAll();
    }

    @Override
    public Optional<DossierDebiteur> getDossierDebiteurById(DossierId dossierId) {
        return dossierDebiteurRepo.findById(dossierId);
    }

    @Override
    public DossierDebiteur saveDossierDebiteur(DossierDebiteur dossierDebiteur) {
        return dossierDebiteurRepo.save(dossierDebiteur);
    }

    @Override
    public void deleteDossierDebiteurById(DossierId dossierId) {
        dossierDebiteurRepo.deleteById(dossierId);
    }
}
