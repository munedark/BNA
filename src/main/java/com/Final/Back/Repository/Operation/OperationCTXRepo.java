package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.OperationCTX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationCTXRepo extends JpaRepository<OperationCTX,Long> {
    List<OperationCTX> findByTypeOperation_LibelleOperation(String libelleOperation);
}
