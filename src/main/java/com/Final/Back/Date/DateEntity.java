package com.Final.Back.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class DateEntity {

    @Id
    private Long idDate;

    private LocalDate bnaDate;


}