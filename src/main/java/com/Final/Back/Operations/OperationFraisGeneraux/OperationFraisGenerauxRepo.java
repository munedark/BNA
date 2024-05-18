package com.Final.Back.Operations.OperationFraisGeneraux;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationFraisGenerauxRepo extends JpaRepository<OperationFraisGeneraux,Long> {
}
