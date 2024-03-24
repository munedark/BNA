package com.Final.Back.Repository;

import com.Final.Back.Modles.TypePaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaimentRepo extends JpaRepository<TypePaiment,Long> {
}
