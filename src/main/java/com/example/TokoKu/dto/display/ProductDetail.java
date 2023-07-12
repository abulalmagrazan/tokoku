package com.example.TokoKu.dto.display;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetail {
    private Long id;
    private String productName;
    private Double price;
    private String description;
    private String image;
    private Long idShop;
    private String shopName;
    private String imageShop;

}
