package com.example.TokoKu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name="Role")
    private String role;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
