package com.Final.Back.Controllers.Risque;

import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Services.RisqueServ.RisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent/risque")
public class RisqueController {

    private final RisqueService risqueService;

    @Autowired
    public RisqueController(RisqueService risqueService) {
        this.risqueService = risqueService;
    }

    @GetMapping("/all")
    public List<Risque> getAllRisques() {
        return risqueService.getAllRisques();
    }

    @GetMapping("/{id}")
    public Optional<Risque> getRisqueById(@PathVariable Long id) {
        return risqueService.getRisqueById(id);
    }

    @PostMapping("/add")
    public Risque saveRisque(@RequestBody Risque risque) {
        return risqueService.saveRisque(risque);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRisqueById(@PathVariable Long id) {
        risqueService.deleteRisqueById(id);
    }

    @GetMapping("/risqueNull")
    public List<Risque> getRisquesWithZeroSoldeIrIc() {
        return risqueService.getRisquesWithZeroSoldeIrIc();
    }
}
