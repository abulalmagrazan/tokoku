package com.example.TokoKu.service.interfacefile;

import com.example.TokoKu.dto.display.ShopBySellerDto;
import com.example.TokoKu.dto.upsert.NewAccountDto;
import com.example.TokoKu.dto.upsert.RegisterAccountDto;

import java.util.List;

public interface SellersService {
    public void add(RegisterAccountDto dto);
    public Long findSellerId(String username);

    public String findSellerName(String username);

}
