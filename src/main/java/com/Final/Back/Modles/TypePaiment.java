package com.Final.Back.Modles;

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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="idPaiment",nullable=false,unique=true)
    private Long idPaiment;
    @Column(name = "libelle",unique = true)
    private String libelle;



}
