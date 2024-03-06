package com.Final.Back.Modles;

import lombok.*;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.Column;
import javax.persistence.Entity;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Client extends Utilisateur{
    @Column(unique = true)
    String matriculeClient;
}
