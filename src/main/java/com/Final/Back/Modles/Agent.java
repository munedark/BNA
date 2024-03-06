package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor

@RequiredArgsConstructor
@ToString
@Entity
public class Agent extends Utilisateur {
    @Column(unique = true)
    private Long matriculeAgent;
}
