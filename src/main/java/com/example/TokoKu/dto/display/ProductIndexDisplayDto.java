package com.example.TokoKu.dto.display;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductIndexDisplayDto {

    private Long id;
    private String name;

    private Integer stock;
    private Double price;
    private String image;
}
