package com.Final.Back.Dto;

import com.Final.Back.Modles.Utilisateurs.AgentBna;
import com.Final.Back.Modles.Authentification.Profile;
import lombok.Data;

@Data
public class AuthADto {
    private AgentBna agent;
    private Profile profile;

}
