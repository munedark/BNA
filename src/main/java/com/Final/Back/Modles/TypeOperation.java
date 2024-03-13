package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "typeOperation")
public class TypeOperation {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="idOperation",nullable=false,unique=true)
    private int idOperation;
    @Column(name = "libellOperation", unique = true)
    private String libelleOperation;
}
