package com.Final.Back.Repository.Risque;

import com.Final.Back.Modles.Risques.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisqueRepo extends JpaRepository<Risque,Long> {
}
