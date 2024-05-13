package com.Final.Back.GeneralAuxiliaire;

import com.Final.Back.Dto.updateDto;
import com.Final.Back.GeneralNonAuxiliaire.OperationNonAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public OperationAux updateOperationFraisGenraux(@PathVariable Long id, @RequestBody updateDto u) {
        return operationAuxService.updateOperationFraisGenraux(id, u.getMatriculeValidateur(), u.getDateValidation(), u.getEtatOperation());
    }
    @GetMapping("/validation")
    public List<OperationAux> getOperationsSansMatriculeValidateur() {
        return operationAuxService.getOperationsSansMatriculeValidateur();
    }
    @DeleteMapping("/{id}")
    public void deleteOperationAux(@PathVariable Long id) {
        operationAuxService.deleteOperationAux(id);
    }
    @GetMapping("/all")
    public List<OperationAux> getAllOperations() {
        return operationAuxService.getAllOperations();
    }
}
