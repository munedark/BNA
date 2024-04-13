package com.Final.Back.Repository.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Huissier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuissierRepo extends JpaRepository<Huissier,Long> {
}
