package com.Final.Back.Controllers;

import com.Final.Back.Dto.DebiteurInfo;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Services.RechercheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class RechercheController {
    @Autowired
    RechercheService rechercheService;
    @GetMapping("/debiteur/recherche/{numCtx}")
    @ResponseBody
    DebiteurInfo recherche(@PathVariable Long numCtx){
        return rechercheService.recherche(numCtx);}
    @GetMapping("/debiteur/rechercher/{numCtx}")
    @ResponseBody
    DossierDebiteur rechercher(@PathVariable Long numCtx) {
        return rechercheService.rechercher(numCtx);
    }
}
