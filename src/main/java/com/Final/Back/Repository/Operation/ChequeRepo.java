package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChequeRepo extends JpaRepository<Cheque, Long> {
    Optional<Cheque> findByNumCheque(Long numCheque);
}
