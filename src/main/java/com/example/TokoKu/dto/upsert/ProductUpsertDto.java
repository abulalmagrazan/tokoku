package com.example.TokoKu.dto.upsert;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class ProductUpsertDto {

    private Long id;
    private String name;
    private Long idShop;
    private String idCategory;
    private String description;
    private double price;
    private Integer stock;
    private String imagePath;
    public MultipartFile image;

    public ProductUpsertDto(Long id, String name, Long idShop, Long idCategory, String description, double price, int stock, String imagePath) {
        this.id = id;
        this.name = name;
        this.idShop = idShop;
        this.idCategory = idCategory.toString();
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imagePath = imagePath;
    }
}
