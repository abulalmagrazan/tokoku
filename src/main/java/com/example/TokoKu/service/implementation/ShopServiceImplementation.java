package com.example.TokoKu.service.implementation;

import com.example.TokoKu.dao.ShopRepository;
import com.example.TokoKu.dto.ListIdValueDto;
import com.example.TokoKu.dto.display.ProfileDisplayDto;
import com.example.TokoKu.dto.display.ShopBySellerDto;
import com.example.TokoKu.dto.display.ShopProfileDto;
import com.example.TokoKu.dto.upsert.ShopUpsertDto;
import com.example.TokoKu.entity.Shop;
import com.example.TokoKu.service.interfacefile.SellersService;
import com.example.TokoKu.service.interfacefile.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShopServiceImplementation implements ShopService {

    @Autowired
    ShopRepository shopRepository;


    @Override
    public ProfileDisplayDto getProfile(String username) {
        return null;
//        return shopRepository.getProfile(username);
    }

    @Override
    public List<ShopBySellerDto> shopBySeller(String username) {
        return shopRepository.shopBySeller(username);
    }

    @Override
    public void add(ShopUpsertDto dto, Long sellerId) {
        Shop entity=new Shop(dto.getId(),sellerId,dto.getShopName(),dto.getDetail(),dto.getAddress(),dto.getCity(),LocalDate.now(),dto.getImagePath());
        shopRepository.save(entity);
    }

    @Override
    public List<ListIdValueDto> shopListByUser(String username,Long shopIdActive) {
        return shopRepository.shopListByUser(username,shopIdActive);
    }

    @Override
    public String findCurrentShop(Long shopId) {
        return shopRepository.findCurrentShop(shopId);
    }

    @Override
    public ShopUpsertDto findShopById(Long shopId) {
        return shopRepository.findShopById(shopId);
    }

    @Override
    public ShopProfileDto findShopProfile(Long shopId, String username) {
        return shopRepository.findShopProfile(shopId,username);
    }


}
