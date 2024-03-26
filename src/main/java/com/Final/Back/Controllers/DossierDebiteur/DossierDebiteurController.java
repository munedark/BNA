package com.Final.Back.Controllers.DossierDebiteur;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.DossierDebiteur.DossierId;
import com.Final.Back.Services.DossierDebiteurServ.DossierDebiteurServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/dossier-debiteur")
public class DossierDebiteurController {
    @Autowired
    DossierDebiteurServ dossierDebiteurService;



    @GetMapping("/all")
    public List<DossierDebiteur> getAllDossierDebiteurs() {
        return dossierDebiteurService.getAllDossierDebiteurs();
    }

    @GetMapping("/{id}")
    public Optional<DossierDebiteur> getDossierDebiteurById(@PathVariable("id") DossierId dossierId) {
        return dossierDebiteurService.getDossierDebiteurById(dossierId);
    }

    @PostMapping("/add")
    public DossierDebiteur saveDossierDebiteur(@RequestBody DossierDebiteur dossierDebiteur) {
        return dossierDebiteurService.saveDossierDebiteur(dossierDebiteur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDossierDebiteurById(@PathVariable("id") DossierId dossierId) {
        dossierDebiteurService.deleteDossierDebiteurById(dossierId);
    }
}
