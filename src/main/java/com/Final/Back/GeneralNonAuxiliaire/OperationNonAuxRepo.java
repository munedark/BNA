package com.Final.Back.GeneralNonAuxiliaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationNonAuxRepo extends JpaRepository<OperationNonAux,Long> {
}
