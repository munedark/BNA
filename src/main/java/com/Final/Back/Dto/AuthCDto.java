package com.Final.Back.Dto;


import com.Final.Back.Modles.Authentification;
import com.Final.Back.Modles.Client;
import lombok.Data;

@Data
public class AuthCDto {

    private Client c;
    private Authentification auth;
}
