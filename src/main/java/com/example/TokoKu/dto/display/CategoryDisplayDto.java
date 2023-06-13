package com.example.TokoKu.dto.display;

import javax.persistence.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDisplayDto {
    private Long id;
    private String name;
    private String description;
    private String img;
}
