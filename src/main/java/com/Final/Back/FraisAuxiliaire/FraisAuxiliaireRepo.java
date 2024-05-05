package com.Final.Back.FraisAuxiliaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraisAuxiliaireRepo extends JpaRepository<FraisAuxiliaire,Long> {
}
