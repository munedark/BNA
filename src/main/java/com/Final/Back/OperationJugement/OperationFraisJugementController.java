package com.Final.Back.OperationJugement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/agent/operation-frais-jugement")
public class OperationFraisJugementController {

    @Autowired
    private OperationFraisJugementService operationFraisJugementService;

    @PostMapping
    public OperationFraisJugement saveOperationFraisJugement(@RequestBody OperationFraisJugement operationFraisJugement) {
        return operationFraisJugementService.saveOperationFraisJugement(operationFraisJugement);
    }

    @GetMapping("/{id}")
    public OperationFraisJugement getOperationFraisJugementById(@PathVariable Long id) {
        return operationFraisJugementService.getOperationFraisJugementById(id);
    }

    @PutMapping("/{id}")
    public OperationFraisJugement updateOperationFraisGenraux(@PathVariable Long id, @RequestParam String matriculeValidateur,
                                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateValidation,
                                                              @RequestParam String etatOperation) {
        return operationFraisJugementService.updateOperationFraisGenraux(id, matriculeValidateur, dateValidation, etatOperation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperationFraisJugement(@PathVariable Long id) {
        operationFraisJugementService.deleteOperationFraisJugement(id);
    }
}
