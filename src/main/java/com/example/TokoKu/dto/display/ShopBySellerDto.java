package com.example.TokoKu.dto.display;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopBySellerDto {
    private Long id;
    private String shopName;
    private String imagePath;
}
