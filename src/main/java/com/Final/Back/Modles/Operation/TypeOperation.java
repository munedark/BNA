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
    @SequenceGenerator(name = "typeOperation_id_Sequence", sequenceName = "TYPE_OPERATION_ID_SEQ") // Correction du nom de la séquence ici
    @Column(name="idType",nullable=false,unique=true)
    private int idOperation;
    @Column(name = "libelleOperation", unique = true)
    private String libelleOperation;
    @Column(name = "numeroType",unique = true)
    private String numeroType;

}
