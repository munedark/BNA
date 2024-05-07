package com.Final.Back.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class DateBna {

    @Id
    private Long idDate;

    private LocalDate bnaDate;


}