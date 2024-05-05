package com.Final.Back.Controllers.Operation;

import com.Final.Back.Modles.Operation.VirementTelecomponse;
import com.Final.Back.Services.OperationServ.VirementTelecomponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agent/virement")
public class VirementTelecompenceController {
    @Autowired
    VirementTelecomponseService virementService;

    @GetMapping("/all")
    public ResponseEntity<List<VirementTelecomponse>> getAllVirements() {
        List<VirementTelecomponse> virements = virementService.getAllVirements();
        return new ResponseEntity<>(virements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VirementTelecomponse> getVirementById(@PathVariable Long id) {
        VirementTelecomponse virement = virementService.getVirementById(id);
        return virement != null ?
                new ResponseEntity<>(virement, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/date/{dateString}")
    public ResponseEntity<List<VirementTelecomponse>> getVirementsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateString) {
        List<VirementTelecomponse> virements = virementService.getVirementsByDate(dateString);
        return new ResponseEntity<>(virements, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<VirementTelecomponse> createVirement(@RequestBody VirementTelecomponse virement) {
        VirementTelecomponse createdVirement = virementService.createVirement(virement);
        return new ResponseEntity<>(createdVirement, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVirement(@PathVariable Long id) {
        virementService.deleteVirement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/validation")
//    public void validationVirement(@RequestBody VirementTelecomponse virement) {
//        virementService.validerVirement(virement);
//    }
}