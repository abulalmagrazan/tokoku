package com.example.TokoKu.dto.display;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EtalaseProductDto {
    private Long id;
    private String image;
    private String name;
    private Double price;
    private Integer stock;
}
