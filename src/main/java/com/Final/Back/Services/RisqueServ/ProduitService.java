package com.Final.Back.Services.RisqueServ;

import com.Final.Back.Modles.Risques.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    List<Produit> getAllProduits();
    Optional<Produit> getProduitById(Long id);
    Produit saveProduit(Produit produit);
    void deleteProduitById(Long id);
}
