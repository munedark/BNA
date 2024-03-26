package com.Final.Back.Controllers.Risque;

import com.Final.Back.Modles.Risques.Produit;
import com.Final.Back.Services.RisqueServ.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/produit")
public class ProduitController {

    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/all")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public Optional<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @PostMapping("/add")
    public Produit saveProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduitById(@PathVariable Long id) {
        produitService.deleteProduitById(id);
    }
}
