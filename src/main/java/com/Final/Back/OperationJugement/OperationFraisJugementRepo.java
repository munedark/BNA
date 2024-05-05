package com.Final.Back.OperationJugement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationFraisJugementRepo extends JpaRepository<OperationFraisJugement,Long> {
}
