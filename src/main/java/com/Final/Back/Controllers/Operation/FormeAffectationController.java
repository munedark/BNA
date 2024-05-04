package com.Final.Back.Controllers.Operation;

import com.Final.Back.Modles.Operation.FormeAffectation;
import com.Final.Back.Services.OperationServ.FormeAffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent/affectation")
public class FormeAffectationController {

    @Autowired
    private FormeAffectationService formeAffectationService;

    @GetMapping
    public List<FormeAffectation> getAllFormeAffectations() {
        return formeAffectationService.getAllFormeAffectations();
    }

    @GetMapping("/{id}")
    public FormeAffectation getFormeAffectationById(@PathVariable Long id) {
        return formeAffectationService.getFormeAffectationById(id);
    }

    @PostMapping
    public FormeAffectation createFormeAffectation(@RequestBody FormeAffectation formeAffectation) {
        return formeAffectationService.createFormeAffectation(formeAffectation);
    }

    @PutMapping("/{id}")
    public FormeAffectation updateFormeAffectation(@PathVariable Long id, @RequestBody FormeAffectation formeAffectation) {
        return formeAffectationService.updateFormeAffectation(id, formeAffectation);
    }

    @DeleteMapping("/{id}")
    public void deleteFormeAffectation(@PathVariable Long id) {
        formeAffectationService.deleteFormeAffectation(id);
    }
}