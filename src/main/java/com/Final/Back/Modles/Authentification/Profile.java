package com.Final.Back.Modles.Authentification;

import com.Final.Back.Modles.Utilisateurs.Personne;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="id",nullable=false,unique=true)
    private Long id;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "role_id")
    private Role role;
}
