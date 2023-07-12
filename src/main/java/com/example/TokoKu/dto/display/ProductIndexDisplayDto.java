package com.example.TokoKu.dto.display;
import com.example.TokoKu.utility.HelperData;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductIndexDisplayDto {

    private Long id;
    private String name;
    private Integer stock;
    private String price;
    private String image;

    public ProductIndexDisplayDto(Long id, String name, Integer stock, Double price, String image) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = HelperData.formatCurrency(price);
        this.image = image;
    }
}
