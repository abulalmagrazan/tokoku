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
    private Long idCategory;
    private String description;
    private double price;
    private int stock;
    private String imagePath;
    public MultipartFile image;

}
