package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.TypeOperation;
import com.Final.Back.Modles.Operation.TypePaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypePaimentRepo extends JpaRepository<TypePaiment,Long> {
    Optional<TypePaiment> findByLibelle(String libelle);

}
