package com.Final.Back.Services;

import com.Final.Back.Dto.DebiteurInfo;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;

public interface RechercheService {
    DebiteurInfo recherche(Long numCtx);
    DossierDebiteur rechercher(Long numCtx);
}
