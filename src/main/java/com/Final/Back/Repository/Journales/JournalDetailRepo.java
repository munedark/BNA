package com.Final.Back.Repository.Journales;

import com.Final.Back.Modles.Journales.JournalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalDetailRepo extends JpaRepository<JournalDetail,Long> {
}
