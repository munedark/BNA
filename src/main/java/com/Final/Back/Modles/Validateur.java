package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Validateur extends Utilisateur {
    @Column(unique = true)
    private Long matriculeValidateur;
}
