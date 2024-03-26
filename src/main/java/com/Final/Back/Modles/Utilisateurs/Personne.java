package com.Final.Back.Modles.Utilisateurs;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Personne")

public class Personne {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="id",nullable=false,unique=true)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name="email")
    private String email;

    @Column( name = "numTel")
    private String numtele;




}
