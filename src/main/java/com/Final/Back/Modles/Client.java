package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
