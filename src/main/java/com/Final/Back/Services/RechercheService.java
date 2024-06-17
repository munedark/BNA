package com.Final.Back.Services;

import com.Final.Back.Dto.DebiteurInfo;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;

import java.util.List;

public interface RechercheService {
    DebiteurInfo recherche(Long numCtx);
    List<Risque> Risques(Long numCtx);
}
