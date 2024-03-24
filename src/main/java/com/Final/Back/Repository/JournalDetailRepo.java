package com.Final.Back.Repository;

import com.Final.Back.Modles.JournalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalDetailRepo extends JpaRepository<JournalDetail,Long> {
}
