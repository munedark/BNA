package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "AgenceBank")
public class AgenceBank {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="idAgence",nullable=false,unique=true)
    private Long idAgence;
    @Column(name = "emplacement")
    private String emplacement;

}
