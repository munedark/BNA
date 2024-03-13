package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="codeProduit",nullable=false,unique=true)
    private Long codeProduit;
    @Column(name = "libelleProduit")
    private String libelleProduit;
}
