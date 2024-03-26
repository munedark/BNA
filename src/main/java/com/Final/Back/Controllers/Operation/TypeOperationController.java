package com.Final.Back.Controllers.Operation;

import com.Final.Back.Modles.Operation.TypeOperation;
import com.Final.Back.Services.OperationServ.TypeOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/type-operation")
public class TypeOperationController {

    private final TypeOperationService typeOperationService;

    @Autowired
    public TypeOperationController(TypeOperationService typeOperationService) {
        this.typeOperationService = typeOperationService;
    }

    @GetMapping("/all")
    public List<TypeOperation> getAllTypeOperations() {
        return typeOperationService.getAllTypeOperations();
    }

    @GetMapping("/{id}")
    public Optional<TypeOperation> getTypeOperationById(@PathVariable int id) {
        return typeOperationService.getTypeOperationById(id);
    }

    @PostMapping("/add")
    public TypeOperation saveTypeOperation(@RequestBody TypeOperation typeOperation) {
        return typeOperationService.saveTypeOperation(typeOperation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypeOperationById(@PathVariable int id) {
        typeOperationService.deleteTypeOperationById(id);
    }
}
