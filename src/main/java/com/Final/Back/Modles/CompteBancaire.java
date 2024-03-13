package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "CompteBancaire")
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="numCompte",nullable=false,unique=true)
    private Long numCompte ;
    @Column(name = "solde")
    private float solde;
}
