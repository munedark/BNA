package com.Final.Back.TypeCredit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCreditRepo extends JpaRepository<TypeCredit,Long> {
}
