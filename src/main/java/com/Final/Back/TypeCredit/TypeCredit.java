package com.Final.Back.TypeCredit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeCredit {
@Id
    private Long code;
@Column(name = "libelle")
    private String libelle;
}
