package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.Cheque;
import org.hibernate.annotations.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeRepo extends JpaRepository<Cheque, Long> {
    // Add custom queries if needed
}
