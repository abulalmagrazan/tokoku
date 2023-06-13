package com.example.TokoKu.service.interfacefile;

import com.example.TokoKu.dto.display.EtalaseProductDto;
import com.example.TokoKu.dto.display.ProductIndexDisplayDto;
import com.example.TokoKu.dto.display.ProductShopDto;

import java.util.List;

public interface ProductsService {
    public List<ProductIndexDisplayDto>getAll();
    public List<EtalaseProductDto>getBySeller(String username,String productName,Integer page);

    public long getCountPage(String username,String name);
    public long getCountPage(Long shopId,String productName);
    public List<ProductShopDto> getShopProduct(Long ShopId,String productName,Integer page);
}
