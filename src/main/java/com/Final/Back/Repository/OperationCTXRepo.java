package com.Final.Back.Repository;

import com.Final.Back.Modles.OperationCTX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationCTXRepo extends JpaRepository<OperationCTX,Long> {
}
