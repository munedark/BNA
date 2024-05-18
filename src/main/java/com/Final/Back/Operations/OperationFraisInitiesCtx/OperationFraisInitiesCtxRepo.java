package com.Final.Back.Operations.OperationFraisInitiesCtx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationFraisInitiesCtxRepo extends JpaRepository<OperationFraisInitiesCTX,Long> {
    List<OperationFraisInitiesCTX> findByMatriculeValidateurIsNull();

}
