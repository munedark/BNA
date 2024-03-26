package com.Final.Back.Modles.Operation;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "TypePaiment")
public class TypePaiment {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "typePaiment_id_Sequence")
    @SequenceGenerator(name = "typePaiment_id_Sequence", sequenceName = "TYPE_PAIMENT_ID_SEQ")
    @Column(name="idPaiment",nullable=false,unique=true)
    private Long idPaiment;
    @Column(name = "libelle",unique = true)
    private String libelle;



}
