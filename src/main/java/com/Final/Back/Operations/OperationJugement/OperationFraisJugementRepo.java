package com.Final.Back.Operations.OperationJugement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationFraisJugementRepo extends JpaRepository<OperationFraisJugement,Long> {
    List<OperationFraisJugement> findByMatriculeValidateurIsNull();
}
