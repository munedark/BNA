package com.Final.Back.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    public LocalDate getDate() {
        return dateRepository.findById(1L).orElse(new DateEntity()).getBnaDate();
    }

    public void setDate(LocalDate newDate) {
        DateEntity dateEntity = dateRepository.findById(1L).orElse(new DateEntity());
        dateEntity.setBnaDate(newDate);
        dateRepository.save(dateEntity);
    }

    public void incrementDate() {
        DateEntity dateEntity = dateRepository.findById(1L).orElse(new DateEntity());
        LocalDate currentDate = dateEntity.getBnaDate();
        LocalDate updatedDate = currentDate.plusDays(1);
        dateEntity.setBnaDate(updatedDate);
        dateRepository.save(dateEntity);
    }
}
