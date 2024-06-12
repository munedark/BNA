package com.Final.Back.Modles.Utilisateurs;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
public class Client extends Personne {
    @Column(name = "cin", unique = true)
    Long cin;
  
}
