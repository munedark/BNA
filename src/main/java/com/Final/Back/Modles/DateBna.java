package com.Final.Back.Modles;

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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "date_id_Sequence")
    @SequenceGenerator(name = "date_id_Sequence", sequenceName = "DATE_ID_SEQ")
    @Column(name="IdDate",nullable=false,unique=true)
    private Long IdDate;
    private LocalDate dateBna;
}
