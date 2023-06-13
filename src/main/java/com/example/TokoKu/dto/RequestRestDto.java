package com.example.TokoKu.dto;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestRestDto {
    private String subject;
    private String secretKey;
    private String audience;
    private String username;
    private String password;
    private String role;
}
