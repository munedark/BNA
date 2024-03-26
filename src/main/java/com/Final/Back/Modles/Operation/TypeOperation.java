package com.Final.Back.Modles.Operation;

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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "typeOperation_id_Sequence")
    @SequenceGenerator(name = "typeOperation_id_Sequence", sequenceName = "TYPE_OPERATION_ID_SEQ")
    @Column(name="idType",nullable=false,unique=true)
    private int idOperation;
    @Column(name = "libellOperation", unique = true)
    private String libelleOperation;
}
