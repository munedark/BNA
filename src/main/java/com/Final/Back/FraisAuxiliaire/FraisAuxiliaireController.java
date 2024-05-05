package com.Final.Back.FraisAuxiliaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent/frais-auxiliaire")
public class FraisAuxiliaireController {

    @Autowired
    private FraisAuxiliaireService fraisAuxiliaireService;

    @PostMapping
    public FraisAuxiliaire saveFraisAuxiliaire(@RequestBody FraisAuxiliaire fraisAuxiliaire) {
        return fraisAuxiliaireService.saveFraisAuxiliaire(fraisAuxiliaire);
    }

    @GetMapping("/{id}")
    public FraisAuxiliaire getFraisAuxiliaireById(@PathVariable Long id) {
        return fraisAuxiliaireService.getFraisAuxiliaireById(id);
    }

    @PutMapping("/{id}")
    public FraisAuxiliaire updateFraisAuxiliaire(@PathVariable Long id, @RequestBody FraisAuxiliaire updatedFraisAuxiliaire) {
        return fraisAuxiliaireService.updateFraisAuxiliaire(id, updatedFraisAuxiliaire);
    }

    @DeleteMapping("/{id}")
    public void deleteFraisAuxiliaire(@PathVariable Long id) {
        fraisAuxiliaireService.deleteFraisAuxiliaire(id);
    }
}
