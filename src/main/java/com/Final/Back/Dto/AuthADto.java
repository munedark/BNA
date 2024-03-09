package com.Final.Back.Dto;

import com.Final.Back.Modles.AgentBna;
import com.Final.Back.Modles.Profile;
import lombok.Data;

@Data
public class AuthADto {
    private AgentBna agent;
    private Profile profile;
}
