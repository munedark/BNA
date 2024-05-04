package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.OperationCTX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationCTXRepo extends JpaRepository<OperationCTX,Long> {

    @Query("SELECT o FROM OperationCTX o WHERE o.typeOperation.libelleOperation = :libelleOperation")
    List<OperationCTX> findByTypeOperationLibelleOperation(String libelleOperation);
    @Query("SELECT o FROM OperationCTX o WHERE o.virementTelecomponse.validation = 'validé'")
    List<OperationCTX> findOperationsWithValidatedVirement();
}
