package com.example.TokoKu.dto.upsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewAccountDto {
    public Long id;
    @NotBlank(message = "username harus diisi")
    public String username;
    @NotBlank(message = "password harus diisi")
    public String password;
}
