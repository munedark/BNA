package com.Final.Back.Operations.GeneralNonAuxiliaire;

import com.Final.Back.Dto.updateDto;
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


    @PutMapping("/{id}")
    public OperationNonAux updateOperationFraisGenraux(@PathVariable Long id, @RequestBody updateDto u) {
        return operationNonAuxService.updateOperationFraisGenraux(id, u.getMatriculeValidateur(), u.getDateValidation(), u.getEtatOperation(),u.getRisque());
    }

    @GetMapping("/validation")
    public List<OperationNonAux> getOperationsSansMatriculeValidateur() {
        return operationNonAuxService.getOperationsSansMatriculeValidateur();
    }
    @DeleteMapping("/{id}")
    public void deleteOperationNonAux(@PathVariable Long id) {
        operationNonAuxService.deleteOperationNonAux(id);
    }

    @GetMapping("/all")
    public List<OperationNonAux> getAllOperations() {
        return operationNonAuxService.getAllOperations();
    }
}
