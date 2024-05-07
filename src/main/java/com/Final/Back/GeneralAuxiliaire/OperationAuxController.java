package com.Final.Back.GeneralAuxiliaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent/aux")
public class OperationAuxController {
    @Autowired
    private OperationAuxService operationAuxService;

    @PostMapping("/add")
    public OperationAux saveOperationAux(@RequestBody OperationAux operationAux) {
        return operationAuxService.saveOperationAux(operationAux);
    }

    @GetMapping("/{id}")
    public OperationAux getOperationAuxById(@PathVariable Long id) {
        return operationAuxService.getOperationAuxById(id);
    }

    @PutMapping("/{id}")
    public OperationAux updateOperationAux(@PathVariable Long id, @RequestBody OperationAux updatedOperationAux) {
        return operationAuxService.updateOperationAux(id, updatedOperationAux);
    }

    @DeleteMapping("/{id}")
    public void deleteOperationAux(@PathVariable Long id) {
        operationAuxService.deleteOperationAux(id);
    }
}
