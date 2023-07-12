package com.example.TokoKu.service.implementation;

import com.example.TokoKu.dao.ProductsRepository;
import com.example.TokoKu.dto.display.EtalaseProductDto;
import com.example.TokoKu.dto.display.ProductDetail;
import com.example.TokoKu.dto.display.ProductIndexDisplayDto;
import com.example.TokoKu.dto.display.ProductShopDto;
import com.example.TokoKu.dto.upsert.ProductUpsertDto;
import com.example.TokoKu.entity.Products;
import com.example.TokoKu.service.interfacefile.ProductsService;
import com.example.TokoKu.utility.HelperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImplementation implements ProductsService {


    @Autowired
    ProductsRepository productsRepository;
    private Integer rowPage=5;

    @Override
    public List<ProductIndexDisplayDto> getAll() {
        return productsRepository.getAll();
    }


    @Override
    public long countProductSearch(String name, Double minPrice, Double maxPrice) {
        var rowPage=30;
        double totalData=(double) productsRepository.getCount(name,minPrice,maxPrice);
        long totalPage=(long)(Math.ceil(totalData/rowPage));
        return totalPage;
    }

    @Override
    public List<ProductIndexDisplayDto> getAll(String name, Double minPrice, Double maxPrice, Integer page) {
      var rowPage=30;
        Pageable pagination=PageRequest.of(page-1,rowPage,Sort.by("id"));
        return productsRepository.getAll(name,minPrice,maxPrice,pagination);
    }



    @Override
    public List<EtalaseProductDto> getBySeller(String username,String productName,Integer page) {
        Pageable pagination= PageRequest.of(page-1,rowPage, Sort.by("id"));
        return productsRepository.getBySeller(username,productName,pagination);
    }

    @Override
    public long getCountPage(String username, String name) {
        double totalData=(double)productsRepository.getCount(username,name);
        long totalPage=(long)(Math.ceil(totalData/rowPage));

        return totalPage;
    }

    @Override
    public long getCountPage(Long shopId, String productName) {
        double totalData=(double)productsRepository.getCount(shopId,productName);
        long totalPage=(long)(Math.ceil(totalData/rowPage));

        return totalPage;
    }

    @Override
    public List<ProductShopDto> getShopProduct(Long ShopId,String productName,Integer page) {
        Pageable pagination=PageRequest.of(page-1,rowPage,Sort.by("id"));
        return productsRepository.getShopProduct(ShopId,productName,pagination);
    }

    @Override
    public void add(ProductUpsertDto dto) {
        Products entity=new Products(dto.getId(),dto.getName(),dto.getIdShop(), Long.parseLong(dto.getIdCategory()),dto.getDescription(),dto.getPrice(),dto.getStock(),dto.getImagePath());
        productsRepository.save(entity);
    }

    @Override
    public ProductUpsertDto findByProductId(Long productId) {
        return productsRepository.findByProductId(productId);
    }

    @Override
    public ProductDetail detail(Long productId) {
        ProductDetail data= productsRepository.detail(productId);
        data.setDescription(HelperData.textFormat(data.getDescription()));
        return data;
    }

    @Override
    public List<ProductIndexDisplayDto> getByShopId(Long shopId) {
        return productsRepository.getByShopId(shopId);
    }
}
