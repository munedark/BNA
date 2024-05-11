package com.Final.Back.OperationJugement;

import com.Final.Back.Dto.updateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public OperationFraisJugement updateOperationFraisGenraux(@PathVariable Long id, @RequestBody updateDto u) {
        return operationFraisJugementService.updateOperationFraisGenraux(id, u.getMatriculeValidateur(), u.getDateValidation(), u.getEtatOperation());
    }

    @DeleteMapping("/{id}")
    public void deleteOperationFraisJugement(@PathVariable Long id) {
        operationFraisJugementService.deleteOperationFraisJugement(id);
    }
    @GetMapping("/validation")
    public List<OperationFraisJugement> getOperationsSansMatriculeValidateur() {
        return operationFraisJugementService.getOperationsSansMatriculeValidateur();
    }
    @GetMapping("/all")
    public List<OperationFraisJugement> getAllOperationsFraisJugement() {
        return operationFraisJugementService.findAll();
    }
}
