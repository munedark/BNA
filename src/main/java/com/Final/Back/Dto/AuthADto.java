package com.Final.Back.Dto;

import com.Final.Back.Modles.Agent;
import com.Final.Back.Modles.Authentification;
import lombok.Data;

@Data
public class AuthADto {
    private Agent a;
    private Authentification auth;
}
