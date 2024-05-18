package com.Final.Back.Operations.OperationFraisGeneraux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agent/operations-frais")
public class OperationFraisGenerauxController {

    @Autowired
    private OperationFraisGenerauxService operationFraisGenerauxService;

    @PostMapping
    public OperationFraisGeneraux saveOperation(@RequestBody OperationFraisGeneraux operation) {
        return operationFraisGenerauxService.saveOperation(operation);
    }

    @GetMapping("/{id}")
    public OperationFraisGeneraux getOperationById(@PathVariable Long id) {
        return operationFraisGenerauxService.getOperationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable Long id) {
        operationFraisGenerauxService.deleteOperation(id);
    }

    @PutMapping("/{id}")
    public OperationFraisGeneraux updateOperationFraisGenraux(@PathVariable Long id, @RequestParam String matriculeValidateur,
                                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateValidation,
                                                              @RequestParam String etatOperation) {
        return operationFraisGenerauxService.updateOperationFraisGenraux(id, matriculeValidateur, dateValidation, etatOperation);
    }

    @GetMapping("/all")
    public List<OperationFraisGeneraux> getAllOperations() {
        return operationFraisGenerauxService.getAllOperations();
    }
}
