package com.Final.Back.Repository.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Auxiliaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuxiliaireRepo extends JpaRepository<Auxiliaire,Long> {
}
