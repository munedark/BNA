package com.Final.Back.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController

public class DateController {

    @Autowired
    private DateService dateService;

    @GetMapping("/date")
    public LocalDate getDate() {
        return dateService.getDate();
    }

    @PostMapping("/admin/date/set")
    public void setDate(@RequestBody  String newDate) {
        LocalDate localDate = LocalDate.parse(newDate);
        dateService.setDate(localDate);
    }

    @PostMapping("/agent/date/increment")
    public void incrementDate() {
        dateService.incrementDate();
    }
      }