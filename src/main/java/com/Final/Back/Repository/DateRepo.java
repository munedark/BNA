package com.Final.Back.Repository;

import com.Final.Back.Modles.DateBna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepo extends JpaRepository<DateBna,Long> {
}
