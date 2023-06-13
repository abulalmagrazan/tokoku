package com.example.TokoKu.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class LoginAccessDto {
    private String username;
    private String password;
    private String AccountRole;
    private String loginPageRole;
}
