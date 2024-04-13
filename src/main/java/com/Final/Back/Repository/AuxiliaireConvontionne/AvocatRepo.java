package com.Final.Back.Repository.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Avocat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvocatRepo extends JpaRepository<Avocat,Long> {
}
