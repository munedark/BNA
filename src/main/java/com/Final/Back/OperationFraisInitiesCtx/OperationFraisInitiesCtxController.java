package com.Final.Back.OperationFraisInitiesCtx;

import com.Final.Back.Dto.updateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public OperationFraisInitiesCTX updateOperationFraisGenraux(@PathVariable Long id, @RequestBody updateDto u) {
        return operationFraisInitiesCtxService.updateOperationFraisGenraux(id, u.getMatriculeValidateur(), u.getDateValidation(), u.getEtatOperation());
    }

    @GetMapping("/validation")
    public List<OperationFraisInitiesCTX> getOperationsSansMatriculeValidateur() {
        return operationFraisInitiesCtxService.getOperationsSansMatriculeValidateur();
    }
    @GetMapping("/all")
    public List<OperationFraisInitiesCTX> getAllOperations() {
        return operationFraisInitiesCtxService.getAllOperations();
    }

}
