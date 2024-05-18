package com.Final.Back.Operations.GeneralNonAuxiliaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationNonAuxRepo extends JpaRepository<OperationNonAux,Long> {
    List<OperationNonAux> findByMatriculeValidateurIsNull();
}
