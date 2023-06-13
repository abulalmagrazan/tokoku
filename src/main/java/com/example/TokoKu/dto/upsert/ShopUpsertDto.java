package com.example.TokoKu.dto.upsert;

import com.example.TokoKu.validation.ShopName;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ShopName(usernameField = "shopName",idShopField = "id")
public class ShopUpsertDto {
    private Long id;


    @Size(max = 50,message = "Maximal 50 Character")
    @NotBlank(message = "Not Blank")
    private String shopName;

    @NotBlank(message = "Not Blank")
    private String detail;

    @NotBlank(message = "Not Blank")
    private String address;

    @NotBlank(message = "Not Blank")
    private String city;

    private String imagePath;

    private MultipartFile image;

    public ShopUpsertDto(Long id, String shopName, String detail, String address, String city, String imagePath) {
        this.id = id;
        this.shopName = shopName;
        this.detail = detail;
        this.address = address;
        this.city = city;
        this.imagePath = imagePath;
    }
}
