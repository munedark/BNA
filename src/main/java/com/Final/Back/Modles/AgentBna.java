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
public class AgentBna extends Personne {
    @Column(unique = true)
    private Long matricule;
}
