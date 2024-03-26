package com.Final.Back.Controllers.Operation;

import com.Final.Back.Modles.Operation.OperationCTX;
import com.Final.Back.Services.OperationServ.OperationCTXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/operation-ctx")
public class OperationCTXController {

    private final OperationCTXService operationCTXService;

    @Autowired
    public OperationCTXController(OperationCTXService operationCTXService) {
        this.operationCTXService = operationCTXService;
    }

    @GetMapping("/all")
    public List<OperationCTX> getAllOperations() {
        return operationCTXService.getAllOperations();
    }

    @GetMapping("/{id}")
    public Optional<OperationCTX> getOperationById(@PathVariable Long id) {
        return operationCTXService.getOperationById(id);
    }

    @PostMapping("/add")
    public OperationCTX saveOperation(@RequestBody OperationCTX operation) {
        return operationCTXService.saveOperation(operation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOperationById(@PathVariable Long id) {
        operationCTXService.deleteOperationById(id);
    }
}
