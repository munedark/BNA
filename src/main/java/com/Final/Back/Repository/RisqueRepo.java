package com.Final.Back.Repository;

import com.Final.Back.Modles.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisqueRepo extends JpaRepository<Risque,Long> {
}
