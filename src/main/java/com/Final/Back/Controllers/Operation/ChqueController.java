package com.Final.Back.Controllers.Operation;

import com.Final.Back.Modles.Operation.Cheque;
import com.Final.Back.Services.OperationServ.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent/cheque")

public class ChqueController {
    @Autowired
    ChequeService chequeService;



    @GetMapping("/all")
    public List<Cheque> getAllCheques() {
        return chequeService.getAllCheques();
    }

    @GetMapping("/{id}")
    public Optional<Cheque> getChequeById(@PathVariable Long id) {
        return chequeService.getChequeById(id);
    }

    @PostMapping("/add")
    public Cheque saveCheque(@RequestBody Cheque cheque) {
        return chequeService.saveCheque(cheque);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChequeById(@PathVariable Long id) {
        chequeService.deleteChequeById(id);
    }

//    @PutMapping("/update/{id}")
//    public Cheque updateCheque(@PathVariable Long id, @RequestBody Cheque updatedCheque) {
//        return chequeService.updateCheque(id, updatedCheque);
//    }
}
