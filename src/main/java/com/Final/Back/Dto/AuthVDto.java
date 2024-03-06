package com.Final.Back.Dto;

import com.Final.Back.Modles.*;
import lombok.Data;

@Data
public class AuthVDto {
    private Validateur v;

    private Authentification auth;
}
