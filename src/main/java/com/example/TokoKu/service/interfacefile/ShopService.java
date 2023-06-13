package com.example.TokoKu.service.interfacefile;


import com.example.TokoKu.dto.ListIdValueDto;
import com.example.TokoKu.dto.display.ProfileDisplayDto;
import com.example.TokoKu.dto.display.ShopBySellerDto;
import com.example.TokoKu.dto.display.ShopProfileDto;
import com.example.TokoKu.dto.upsert.ShopUpsertDto;

import java.util.List;

public interface ShopService {
    public ProfileDisplayDto getProfile(String username);
    public List<ShopBySellerDto> shopBySeller(String username);

    public void add(ShopUpsertDto dto,Long sellerId);


    public List<ListIdValueDto> shopListByUser(String username,Long shopIdActive);

    public String findCurrentShop(Long shopId);

    public ShopUpsertDto findShopById(Long shopId);

    public ShopProfileDto findShopProfile(Long shopId, String username);
}
