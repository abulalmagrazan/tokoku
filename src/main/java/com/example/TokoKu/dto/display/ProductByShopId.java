package com.example.TokoKu.dto.display;

import com.example.TokoKu.utility.HelperData;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class ProductByShopId {
    private Long id;
    private String name;
    private Integer stock;
    private String price;
    private String image;

    public ProductByShopId(Long id, String name, Integer stock, Double price, String image) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = HelperData.formatCurrency(price);
        this.image = image;
    }
}
