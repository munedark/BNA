package com.Final.Back.Modles;

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
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @OneToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}