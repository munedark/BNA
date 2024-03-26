package com.Final.Back.Modles.Utilisateurs;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Client extends Personne {

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CompteBancaire> comptesBancaires;
}
