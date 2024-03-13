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
    private String username;
    private String password;
    private Boolean isEnabled;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Personne user;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}