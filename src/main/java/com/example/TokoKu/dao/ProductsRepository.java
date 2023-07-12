package com.example.TokoKu.dao;


import com.example.TokoKu.dto.display.EtalaseProductDto;
import com.example.TokoKu.dto.display.ProductDetail;
import com.example.TokoKu.dto.display.ProductIndexDisplayDto;
import com.example.TokoKu.dto.display.ProductShopDto;
import com.example.TokoKu.dto.upsert.ProductUpsertDto;
import com.example.TokoKu.entity.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Products,Long> {

    @Query("""
            SELECT new com.example.TokoKu.dto.display.ProductIndexDisplayDto(pr.id,pr.name,pr.stock,pr.price,pr.image)
            FROM Products AS pr
            ORDER BY NEWID()
            """)
    public List<ProductIndexDisplayDto>getAll();

   @Query("""
            SELECT new com.example.TokoKu.dto.display.ProductIndexDisplayDto(pr.id,pr.name,pr.stock,pr.price,pr.image)
            FROM Products AS pr
            WHERE (pr.price>=:minPrice AND pr.price<=:maxPrice) AND(pr.name LIKE %:name%)
      
            """)
    public List<ProductIndexDisplayDto>getAll(@Param("name")String name,@Param("minPrice")Double minPrice,@Param("maxPrice")Double maxPrice,Pageable pagination);

    @Query("""
            SELECT new com.example.TokoKu.dto.display.EtalaseProductDto(pr.id,pr.image, pr.name,pr.price,pr.stock)
            FROM Products AS pr
            LEFT JOIN pr.shop as sh
            LEFT JOIN sh.sellers as se
            where se.username=:username AND pr.name LIKE %:productName%
            """)
    public List<EtalaseProductDto>getBySeller(@Param("username")String username, @Param("productName")String productName, Pageable pagination);

    @Query("""
            SELECT COUNT(*)
            FROM Products AS pr
            LEFT JOIN pr.shop as sh
            LEFT JOIN sh.sellers as se
            where se.username=:username AND pr.name LIKE %:name%
            """)
    public long getCount(@Param("username")String username,@Param("name")String name);
    @Query("""
            SELECT COUNT(*)
            FROM Products AS pr
            LEFT JOIN pr.shop as sh
            LEFT JOIN sh.sellers as se
            where sh.id=:shopId AND pr.name LIKE %:productName%
            """)
    public long getCount(@Param("shopId")Long shopId,@Param("productName")String ProductName);

 @Query("""
            SELECT COUNT(*)
            FROM Products AS pr
            WHERE (pr.price>=:minPrice AND pr.price<=:maxPrice) AND (pr.name LIKE %:name%)
            """)
    public long getCount(@Param("name")String name,@Param("minPrice")Double minPrice,@Param("maxPrice")Double maxPrice);


    @Query("""
            SELECT new com.example.TokoKu.dto.display.ProductShopDto(pr.id,pr.name,pr.stock,pr.price,pr.image)
            FROM Products AS pr
            JOIN pr.shop as sh
            WHERE sh.id=:shopId AND pr.name LIKE %:productName%
            """)
    public List<ProductShopDto> getShopProduct(@Param("shopId")Long shopId, @Param("productName")String productName,Pageable pagination);


    @Query("""
            SELECT new com.example.TokoKu.dto.upsert.ProductUpsertDto(pr.id,pr.name,pr.idShop,pr.idCategory,pr.description,pr.price,pr.stock,pr.image)
            FROM Products AS pr
            WHERE pr.id=:productId
            """)
    public ProductUpsertDto findByProductId(@Param("productId")Long productId);

    @Query("""
            SELECT new com.example.TokoKu.dto.display.ProductDetail(pr.id,pr.name,pr.price,pr.description,pr.image,sh.id,sh.shopName,sh.imagePath)
            FROM Products AS pr
            LEFT JOIN pr.shop AS sh
            WHERE pr.id=:productId
            """)
    public ProductDetail detail(@Param("productId")Long productId);

    @Query("""
            SELECT new com.example.TokoKu.dto.display.ProductIndexDisplayDto(pr.id,pr.name,pr.stock,pr.price,pr.image)
            FROM Products AS pr
            LEFT JOIN pr.shop AS sh
            WHERE sh.id=:shopId
            """)
    public List<ProductIndexDisplayDto> getByShopId(@Param("shopId")Long shopId);
}
