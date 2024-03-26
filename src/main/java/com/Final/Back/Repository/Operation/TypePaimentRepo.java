package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.TypePaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaimentRepo extends JpaRepository<TypePaiment,Long> {
}
