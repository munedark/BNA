package com.Final.Back.Controllers.Operation;

import com.Final.Back.Modles.Operation.TypeOperation;
import com.Final.Back.Modles.Operation.TypePaiment;
import com.Final.Back.Services.OperationServ.TypePaimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent/type-paiment")
public class TypePaimentController {

    private final TypePaimentService typePaimentService;

    @Autowired
    public TypePaimentController(TypePaimentService typePaimentService) {
        this.typePaimentService = typePaimentService;
    }

    @GetMapping("/all")
    public List<TypePaiment> getAllTypePaiments() {
        return typePaimentService.getAllTypePaiments();
    }

    @GetMapping("/{id}")
    public Optional<TypePaiment> getTypePaimentById(@PathVariable Long id) {
        return typePaimentService.getTypePaimentById(id);
    }

    @GetMapping("/libelle/{libelle}")
    public Optional<TypePaiment> getTypeOperationByLibelle(@PathVariable String libelle) {
        return typePaimentService.getTypePaimentBylibelle(libelle);
    }

    @PostMapping("/add")
    public TypePaiment saveTypePaiment(@RequestBody TypePaiment typePaiment) {
        return typePaimentService.saveTypePaiment(typePaiment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTypePaimentById(@PathVariable Long id) {
        typePaimentService.deleteTypePaimentById(id);
    }
}
