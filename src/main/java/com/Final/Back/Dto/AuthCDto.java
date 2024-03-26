package com.Final.Back.Dto;


import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Modles.Utilisateurs.Client;
import lombok.Data;

@Data
public class AuthCDto {

    private Client client;
    private Profile profile;
}
