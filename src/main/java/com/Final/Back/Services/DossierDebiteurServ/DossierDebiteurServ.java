package com.Final.Back.Services.DossierDebiteurServ;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.DossierDebiteur.DossierId;

import java.util.List;
import java.util.Optional;

public interface DossierDebiteurServ {
    List<DossierDebiteur> getAllDossierDebiteurs();
    Optional<DossierDebiteur> getDossierDebiteurById(DossierId dossierId);
    DossierDebiteur saveDossierDebiteur(DossierDebiteur dossierDebiteur);
    void deleteDossierDebiteurById(DossierId dossierId);
}
