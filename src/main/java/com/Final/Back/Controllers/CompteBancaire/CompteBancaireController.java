package com.Final.Back.Controllers.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Services.CompteBancaireServ.CompteBancaireServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CompteBancaireController {

    @Autowired
    private CompteBancaireServ compteBancaireServ;

    @PostMapping("/addCompteBancaire")
    public CompteBancaire addCompteBancaire(@RequestBody CompteBancaire compteBancaire) {
        return compteBancaireServ.addCompteBancaire(compteBancaire);
    }

    @GetMapping("/compteBancaire/{id}")
    public CompteBancaire getCompteBancaireById(@PathVariable Long id) {
        return compteBancaireServ.getCompteBancaireById(id);
    }

    @GetMapping("/compteBancaire/all")
    public List<CompteBancaire> getAllComptesBancaires() {
        return compteBancaireServ.getAllComptesBancaires();
    }

    @PutMapping("/compteBancaire/{id}")
    public CompteBancaire updateCompteBancaire(@PathVariable Long id, @RequestBody CompteBancaire compteBancaire) {
        compteBancaire.setNumCompte(id);
        return compteBancaireServ.updateCompteBancaire(compteBancaire);
    }

    @DeleteMapping("/compteBancaire/{id}")
    public void deleteCompteBancaire(@PathVariable Long id) {
        compteBancaireServ.deleteCompteBancaire(id);
    }
}
