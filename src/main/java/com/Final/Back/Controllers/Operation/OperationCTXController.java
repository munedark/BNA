package com.Final.Back.Controllers.Operation;

import com.Final.Back.Dto.OperationDTO;
import com.Final.Back.Modles.Operation.OperationCTX;
import com.Final.Back.Services.OperationServ.OperationCTXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/agent/operation-ctx")
public class OperationCTXController {

    private final SimpMessagingTemplate messagingTemplate;
    private final OperationCTXService operationCTXService;

    @Autowired
    public OperationCTXController(SimpMessagingTemplate messagingTemplate, OperationCTXService operationCTXService) {
        this.messagingTemplate = messagingTemplate;
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

    @GetMapping("/libelle/{libellee}")
    public List<OperationCTX> findByLibelleOperation(@PathVariable String libellee ) {
        return operationCTXService.findByLibelleOperation(libellee);
    }

    @PostMapping("/add")
    public OperationCTX saveOperation(@RequestBody OperationCTX operation) {
        OperationCTX savedOperation = operationCTXService.saveOperation(operation);
        messagingTemplate.convertAndSend("/topic/operations", savedOperation);
        return savedOperation;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOperationById(@PathVariable Long id) {
        operationCTXService.deleteOperationById(id);
        messagingTemplate.convertAndSend("/topic/operations/deleted", id);
    }

    @PutMapping("/update/{id}")
    public OperationCTX updateOperationCTX(@PathVariable Long id,
                                           @RequestBody OperationDTO operationDTO) {
        return operationCTXService.updateOperationCTX(id,
                operationDTO.getMatriculeValidateur(),
                operationDTO.getDateValidation(),
                operationDTO.getEtatOperation());
    }



}
