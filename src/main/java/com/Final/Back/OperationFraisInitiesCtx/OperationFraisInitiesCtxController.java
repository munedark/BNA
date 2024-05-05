package com.Final.Back.OperationFraisInitiesCtx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/agent/operations-frais-inities")
public class OperationFraisInitiesCtxController {

    @Autowired
    private OperationFraisInitiesCtxService operationFraisInitiesCtxService;

    @PostMapping
    public OperationFraisInitiesCTX saveOperation(@RequestBody OperationFraisInitiesCTX operation) {
        return operationFraisInitiesCtxService.saveOperation(operation);
    }

    @GetMapping("/{id}")
    public OperationFraisInitiesCTX getOperationById(@PathVariable Long id) {
        return operationFraisInitiesCtxService.getOperationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable Long id) {
        operationFraisInitiesCtxService.deleteOperation(id);
    }

    @PutMapping("/{id}")
    public OperationFraisInitiesCTX updateOperationFraisGenraux(@PathVariable Long id, @RequestParam String matriculeValidateur,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateValidation,
                                                                @RequestParam String etatOperation) {
        return operationFraisInitiesCtxService.updateOperationFraisGenraux(id, matriculeValidateur, dateValidation, etatOperation);
    }

}
