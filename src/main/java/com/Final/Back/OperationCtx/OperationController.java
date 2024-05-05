package com.Final.Back.OperationCtx;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Operation.*;
import com.Final.Back.Modles.Risques.Risque;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/agent/operations")
public class OperationController {
    @Autowired
    private OperationService operationService;

    @PostMapping
    public OperationCtx saveOperation(@RequestBody OperationCtx operationCtx) {
        return operationService.saveOperation(operationCtx);
    }

    @GetMapping("/{id}")
    public OperationCtx getOperationById(@PathVariable Long id) {
        return operationService.getOperationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable Long id) {
        operationService.deleteOperation(id);
    }

    @PutMapping("/{id}/update-by-cheque")
    public OperationCtx updateOperationByCheque(@PathVariable Long id, @RequestParam String matriculeValidateur,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateValidation,
                                                @RequestParam String etatOperation) {
        return operationService.updateOperationByCheque(id, matriculeValidateur, dateValidation, etatOperation);
    }

    @PutMapping("/{id}/update-virement")
    public void updateOperationVirement(@PathVariable Long id, @RequestBody OperationCtx operation) {
        operationService.updateOperationVirement(operation);
    }

    @GetMapping("/virement-valide")
    public List<OperationCtx> getValidatedVirementOperations() {
        return operationService.OperationVirementValide();
    }

}