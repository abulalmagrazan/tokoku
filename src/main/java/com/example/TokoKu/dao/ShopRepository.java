package com.example.TokoKu.dao;

import com.example.TokoKu.dto.ListIdValueDto;
import com.example.TokoKu.dto.display.ProfileDisplayDto;
import com.example.TokoKu.dto.display.ShopBySellerDto;
import com.example.TokoKu.dto.display.ShopDetail;
import com.example.TokoKu.dto.display.ShopProfileDto;
import com.example.TokoKu.dto.upsert.ShopUpsertDto;
import com.example.TokoKu.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Long> {

//    @Query("""
//            SELECT new com.example.TokoKu.dto.display.ProfileDisplayDto(sh.shopName,CONCAT(se.firstName,' ',se.lastName))
//            FROM Shop AS sh
//            LEFT JOIN sh.sellers AS se
//            """)
//    public ProfileDisplayDto getProfile(@Param("username")String username);
//
    @Query("""
            SELECT new com.example.TokoKu.dto.display.ShopBySellerDto(sh.id,sh.shopName,sh.imagePath)
            FROM Shop as sh
            JOIN sh.sellers as se
            WHERE se.username=:username
            """)
    public List<ShopBySellerDto>shopBySeller(@Param("username")String username);


    @Query("""
            SELECT new com.example.TokoKu.dto.ListIdValueDto(sh.id,sh.shopName)
            FROM Shop as sh
            JOIN sh.sellers as se
            WHERE se.username=:username AND sh.id!=:shopIdActive AND sh.deleteDate IS NULL
            """)
    public List<ListIdValueDto> shopListByUser(@Param("username")String username,@Param("shopIdActive")Long shopIdActive);


    @Query("""
            SELECT sh.shopName
            FROM Shop AS sh
            WHERE sh.id=:shopId
            """)
    public String findCurrentShop(@Param("shopId")Long shopId);

    @Query("""
            SELECT COUNT(*)
            FROM Shop AS sh
            WHERE sh.shopName=:shopName AND sh.id!=:shopId
            """)
    public int shopNameCount(@Param("shopName")String shopName,@Param("shopId") Long shopId);

    @Query("""
            SELECT new com.example.TokoKu.dto.upsert.ShopUpsertDto(sh.id,sh.shopName,sh.detail,sh.address,sh.city,sh.imagePath)
            FROM Shop AS sh
            WHERE sh.id=:shopId
            """)
    public ShopUpsertDto findShopById(@Param("shopId")Long shopId );


    @Query("""
            SELECT new com.example.TokoKu.dto.display.ShopProfileDto(CONCAT(se.firstName,' ',se.lastName),sh.detail,sh.address,sh.city,sh.imagePath)
            FROM Shop AS sh
            JOIN sh.sellers AS se
            WHERE sh.id=:shopId AND se.username=:username
            """)
    public ShopProfileDto findShopProfile(@Param("shopId") Long shopId,@Param("username") String username);

    @Query("""
            SELECT new com.example.TokoKu.dto.display.ShopDetail(sh.id,sh.shopName,sh.imagePath)
            FROM Shop AS sh
            WHERE sh.id=:shopId
            """)
    public ShopDetail getShop(@Param("shopId")Long shopId);
}
