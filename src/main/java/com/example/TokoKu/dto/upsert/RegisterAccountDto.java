package com.example.TokoKu.dto.upsert;

import com.example.TokoKu.validation.CheckAccountUsername;
import com.example.TokoKu.validation.ConfirmPassword;
import com.example.TokoKu.validation.Password;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ConfirmPassword(passwordField = "password",retypeField = "retypePassword",message = "password tidak sama")
public class RegisterAccountDto {
    @NotBlank(message = "username harus di isi")
    @CheckAccountUsername(message = "Username sudah digunakan")
    public String username;

//    @Password(message = "kurang bagus")
    @NotBlank(message = "Password harus di isi")
    public String password;

    @NotBlank(message = "jangan kosong")
    public String retypePassword;

    @NotBlank(message = "jangan kosong")
    public String firstName;

    @NotBlank(message = "jangan kosong")
    public String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate birthDate;

    @NotBlank(message = "jangan kosong")
    private String gender;

    @NotBlank(message = "jangan kosong")
    private String phone;

    @NotBlank(message = "Email harus diisi")
    private String email;

//    @NotBlank(message = "Role harus di isi")
    public String role;
}
