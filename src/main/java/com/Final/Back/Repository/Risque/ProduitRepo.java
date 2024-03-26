package com.Final.Back.Repository.Risque;

import com.Final.Back.Modles.Risques.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produit,Long> {
}
