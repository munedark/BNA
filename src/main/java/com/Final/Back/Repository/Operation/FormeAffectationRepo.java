package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.FormeAffectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormeAffectationRepo extends JpaRepository<FormeAffectation,Long> {
}
