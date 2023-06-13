package com.example.TokoKu.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class ResponseDto {
    private String username;
    private String role;
    private String token;
}
