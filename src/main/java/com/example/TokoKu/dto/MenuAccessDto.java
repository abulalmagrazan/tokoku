package com.example.TokoKu.dto;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class MenuAccessDto {
    private String name;
    private String controller;
    private String action;
}
