package com.Final.Back.Services.ServImpl.Risque;

import com.Final.Back.Modles.Risques.Produit;
import com.Final.Back.Repository.Risque.ProduitRepo;
import com.Final.Back.Services.RisqueServ.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepo produitRepo;

    @Autowired
    public ProduitServiceImpl(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public Optional<Produit> getProduitById(Long id) {
        return produitRepo.findById(id);
    }

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepo.save(produit);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepo.deleteById(id);
    }
}
