package com.example.TokoKu.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Long id;

    @Column(name = "Username")
    public String username;

    @Column(name = "Password")
    public String password;

    @Column(name = "FirstName")
    public String firstName;

    @Column(name = "LastName")
    public String lastName;

    @Column(name = "BirthDate")
    public LocalDate birthDate;

    @Column(name = "Gender")
    public String gender;

    @Column(name = "Phone")
    public String phone;

    @Column(name = "RegisterDate")
    public LocalDate registerDate;

    public Customers(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
