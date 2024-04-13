package com.Final.Back.Repository.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepo extends JpaRepository<Expert,Long> {
}
