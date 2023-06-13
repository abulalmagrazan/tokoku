package com.example.TokoKu.dto.upsert;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerInsertDto {

    public Long id;
    @NotBlank(message = "username harus diisi")
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public String gender;
    public String phone;
    public LocalDate registerDate;
}
