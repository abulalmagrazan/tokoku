package com.example.TokoKu.dto.display;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ShopProfileDto {
    private String owner;
    private String detail;
    private String address;
    private String city;
    private String imagePath;
}
