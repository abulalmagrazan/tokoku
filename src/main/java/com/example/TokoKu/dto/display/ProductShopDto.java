package com.example.TokoKu.dto.display;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class ProductShopDto {
    private Long idProduct;
    private String productName;
    private int stock;
    private Double price;
    private String imagePath;
}
