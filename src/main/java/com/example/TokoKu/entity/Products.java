package com.example.TokoKu.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "IdShop")
    private Long idShop;

    @Column(name = "IdCategory")
    private Long idCategory;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Stock")
    private Integer stock;

    @Column(name = "Image")
    private String image;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCategory",insertable = false,updatable = false)
    private Categories categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdShop",insertable = false,updatable = false)
    private Shop shop;

    public Products(Long id, String name, Long idShop, Long idCategory, String description, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.idShop = idShop;
        this.idCategory = idCategory;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
