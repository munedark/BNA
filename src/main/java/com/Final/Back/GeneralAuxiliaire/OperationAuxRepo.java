package com.Final.Back.GeneralAuxiliaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationAuxRepo extends JpaRepository<OperationAux,Long> {
    List<OperationAux> findByMatriculeValidateurIsNull();
}
