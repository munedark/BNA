package com.Final.Back.Controllers.CompteBancaire;

import com.Final.Back.Dto.CompteAgenceDTO;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Services.CompteBancaireServ.CompteBancaireServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
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
    public CompteBancaire updateCompteBancaire(@PathVariable("id") Long id, @RequestBody CompteBancaire compteBancaire) {
        // Update the ID of the CompteBancaire object
        compteBancaire.setNumCompte(id);
        return compteBancaireServ.updateCompteBancaire(compteBancaire);
    }


    @DeleteMapping("/compteBancaire/{id}")
    public void deleteCompteBancaire(@PathVariable Long id) {
        compteBancaireServ.deleteCompteBancaire(id);
    }


    @PostMapping("/addCompteToAgenceBank")
    public ResponseEntity<String> addCompteToAgenceBank(@RequestBody CompteAgenceDTO dto) {
        try {
            compteBancaireServ.addCompteBancaireToAgenceBank(dto.getCompteBancaireId(), dto.getAgenceBankId());
            return ResponseEntity.ok("CompteBancaire added to AgenceBank successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while adding CompteBancaire to AgenceBank: " + e.getMessage());
        }
    }

}
