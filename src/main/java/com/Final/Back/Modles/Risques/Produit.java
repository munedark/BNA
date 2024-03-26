package com.Final.Back.Modles.Risques;

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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "produit_id_Sequence")
    @SequenceGenerator(name = "produit_id_Sequence", sequenceName = "PRODUIT_ID_SEQ")
    @Column(name="codeProduit",nullable=false,unique=true)
    private Long codeProduit;
    @Column(name = "libelleProduit")
    private String libelleProduit;
}
