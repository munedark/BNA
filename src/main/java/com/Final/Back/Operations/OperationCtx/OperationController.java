package com.Final.Back.Operations.OperationCtx;

import com.Final.Back.Dto.updateDto;
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

    @PutMapping("/update-by-cheque/{id}")
    public OperationCtx updateOperationByCheque(@PathVariable Long id, @RequestBody updateDto u) {
        return operationService.updateOperationByCheque(id, u.getMatriculeValidateur(), u.getDateValidation(), u.getEtatOperation());
    }
    @PutMapping("/update-by-affectation/{id}")
    public OperationCtx updateOperationByAffectation(@PathVariable Long id, @RequestBody updateDto u) {
        return operationService.updateOperationByAffectation(id, u.getMatriculeValidateur(), u.getDateValidation(), u.getEtatOperation());
    }

    @PutMapping("/update/virement")
    public void updateOperationVirement( @RequestBody OperationCtx operation) {
        operationService.updateOperationVirement(operation);
    }

    @GetMapping("/virement-valide")
    public List<OperationCtx> getValidatedVirementOperations() {
        return operationService.OperationVirementValide();
    }

    @GetMapping("/virementNonValide")
    public List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullVirementTelecomponse() {
        return operationService.getOperationsWithNullMatriculeValidateurAndNotNullVirementTelecomponse();
    }

    @GetMapping("/chequeNonValide")
    public List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullCheque() {
        return operationService.getOperationsWithNullMatriculeValidateurAndNotNullCheque();
    }

    @GetMapping("/forme-affectationNonValide")
    public List<OperationCtx> getOperationsWithNullMatriculeValidateurAndNotNullFormeAffectation() {
        return operationService.getOperationsWithNullMatriculeValidateurAndNotNullFormeAffectation();
    }
    @GetMapping("/cheque/all")
    public List<OperationCtx> getOperationCheque(){
        return operationService.getOperationCheque();
    }
    @PutMapping("/clotureDossier")
    public void clotureDossier(@RequestBody OperationCtx operationCtx)
    { operationService.clotureDossier(operationCtx);}
}