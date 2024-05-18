package com.Final.Back.Dto;

import com.Final.Back.Modles.Risques.Risque;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
public class updateDto {

    private String matriculeValidateur;
    private LocalDate dateValidation;
    private String etatOperation;
    private Risque risque;
}
