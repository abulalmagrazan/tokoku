package com.example.TokoKu.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdSeller")
    private Long idSeller;

    @Column(name = "ShopName")
    private String shopName;

    @Column(name = "Detail")
    private String detail;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "RegisterDate")
    private LocalDate registerDate;

    @Column(name="ImagePath")
    private String imagePath;

    @Column(name = "DeleteDate")
    private LocalDate deleteDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSeller",insertable = false,updatable = false)
    private Sellers sellers;

    public Shop(Long id, Long idSeller, String shopName,String detail, String address, String city, LocalDate registerDate,String imagePath) {
        this.id = id;
        this.idSeller = idSeller;
        this.shopName = shopName;
        this.detail=detail;
        this.address = address;
        this.city = city;
        this.registerDate = registerDate;
        this.imagePath=imagePath;
    }
}
