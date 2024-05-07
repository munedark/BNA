package com.Final.Back.GeneralNonAuxiliaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent/nonAux")
public class OperationNonAuxController {
    @Autowired
    private OperationNonAuxService operationNonAuxService;



    @PostMapping("/add")
    public OperationNonAux saveOperationNonAux(@RequestBody OperationNonAux operationNonAux) {
        return operationNonAuxService.saveOperationNonAux(operationNonAux);
    }

    @GetMapping("/{id}")
    public OperationNonAux getOperationNonAuxById(@PathVariable Long id) {
        return operationNonAuxService.getOperationNonAuxById(id);
    }

    @GetMapping("/all")
    public List<OperationNonAux> getAllOperationNonAux() {
        return operationNonAuxService.getAllOperationNonAux();
    }

    @PutMapping("/{id}")
    public OperationNonAux updateOperationNonAux(@PathVariable Long id, @RequestBody OperationNonAux updatedOperationNonAux) {
        return operationNonAuxService.updateOperationNonAux(id, updatedOperationNonAux);
    }

    @DeleteMapping("/{id}")
    public void deleteOperationNonAux(@PathVariable Long id) {
        operationNonAuxService.deleteOperationNonAux(id);
    }

}
