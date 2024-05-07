package com.Final.Back.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    public LocalDate getDate() {
        return dateRepository.findById(1L).orElse(new DateBna()).getBnaDate();
    }

    public void setDate(LocalDate newDate) {
        DateBna dateBna = dateRepository.findById(1L).orElse(new DateBna());
        dateBna.setBnaDate(newDate);
        dateRepository.save(dateBna);
    }

    public void incrementDate() {
        DateBna dateBna = dateRepository.findById(1L).orElse(new DateBna());
        LocalDate currentDate = dateBna.getBnaDate();
        LocalDate updatedDate = currentDate.plusDays(1);
        dateBna.setBnaDate(updatedDate);
        dateRepository.save(dateBna);
    }
}
