package com.example.TokoKu.service.interfacefile;

import com.example.TokoKu.dto.display.EtalaseProductDto;
import com.example.TokoKu.dto.display.ProductDetail;
import com.example.TokoKu.dto.display.ProductIndexDisplayDto;
import com.example.TokoKu.dto.display.ProductShopDto;
import com.example.TokoKu.dto.upsert.ProductUpsertDto;

import java.util.List;

public interface ProductsService {
    public List<ProductIndexDisplayDto>getAll();

    public List<ProductIndexDisplayDto>getAll(String name,Double minPrice,Double maxPrice,Integer page);

    public long countProductSearch(String name,Double minPrice,Double maxPrice);

    public List<EtalaseProductDto>getBySeller(String username,String productName,Integer page);

    public long getCountPage(String username,String name);
    public long getCountPage(Long shopId,String productName);
    public List<ProductShopDto> getShopProduct(Long ShopId,String productName,Integer page);

    public void add(ProductUpsertDto dto);

    public ProductUpsertDto findByProductId(Long productId);

    public ProductDetail detail(Long productId);

    public List<ProductIndexDisplayDto> getByShopId(Long shopId);
}
