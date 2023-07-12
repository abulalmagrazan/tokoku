package com.example.TokoKu.dto.display;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class CartDto {
    private Long idCustomer;
    private Long idProduct;
    private String productName;
    private String imagePath;
    private Double price;
    private Integer qty;

    public CartDto(Long idProduct, Integer qty) {
        this.idProduct = idProduct;
        this.qty = qty;
    }
}
