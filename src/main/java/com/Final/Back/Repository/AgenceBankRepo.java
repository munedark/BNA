package com.Final.Back.Repository;

import com.Final.Back.Modles.AgenceBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceBankRepo extends JpaRepository<AgenceBank,Long> {
}
