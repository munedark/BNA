package FraisNonAuxiliaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent/frais-non-auxiliaire")
public class FraisNonAuxiliaireController {

    @Autowired
    private FraisNonAuxiliaireService fraisNonAuxiliaireService;

    @PostMapping
    public FraisNonAuxiliaire saveFraisNonAuxiliaire(@RequestBody FraisNonAuxiliaire fraisNonAuxiliaire) {
        return fraisNonAuxiliaireService.saveFraisNonAuxiliaire(fraisNonAuxiliaire);
    }

    @GetMapping("/{id}")
    public FraisNonAuxiliaire getFraisNonAuxiliaireById(@PathVariable Long id) {
        return fraisNonAuxiliaireService.getFraisNonAuxiliaireById(id);
    }

    @PutMapping("/{id}")
    public FraisNonAuxiliaire updateFraisNonAuxiliaire(@PathVariable Long id, @RequestBody FraisNonAuxiliaire updatedFraisNonAuxiliaire) {
        return fraisNonAuxiliaireService.updateFraisNonAuxiliaire(id, updatedFraisNonAuxiliaire);
    }

    @DeleteMapping("/{id}")
    public void deleteFraisNonAuxiliaire(@PathVariable Long id) {
        fraisNonAuxiliaireService.deleteFraisNonAuxiliaire(id);
    }
}
