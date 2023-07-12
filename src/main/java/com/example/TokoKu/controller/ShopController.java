package com.example.TokoKu.controller;

import com.example.TokoKu.dto.display.SellerBreadCrumb;
import com.example.TokoKu.dto.upsert.ShopUpsertDto;
import com.example.TokoKu.service.interfacefile.ProductsService;
import com.example.TokoKu.service.interfacefile.SellersService;
import com.example.TokoKu.service.interfacefile.ShopService;
import com.example.TokoKu.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Service
@RequestMapping("/shop")
public class ShopController extends BaseController {


    @Autowired
    ShopService shopService;

    @Autowired
    SellersService sellersService;

    @Autowired
    ProductsService productsService;


    @GetMapping("/index")
    public String shopCho(Model model){
        if(isAccess("shop","index")) {
            model.addAttribute("currentSeller", getCurrentUser());
            model.addAttribute("listShop", shopService.shopBySeller(getCurrentUser()));
            return "shop/shopCho";
        }
        return "redirect:/access-denied";
    }

    @GetMapping("shopUpsert")
    public String shopUpsert(Model model, @RequestParam(required = false)Long shopId){
        if(isAccess("shop","upsert")) {
            ShopUpsertDto dto = new ShopUpsertDto();
            Helper.setUpsertViewModel(dto, "Create", "Shop", model);
            if (shopId != null) {
                dto = shopService.findShopById(shopId);
                Helper.setUpsertViewModel(dto, "Edit", "Shop", model);
            }
            return "shop/shopUpsert";
        }
        return "redirect:/access-denied";
    }

    @PostMapping("shopUpsert")
    public String shopUpsert(@Valid @ModelAttribute("dto") ShopUpsertDto dto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            Helper.setUpsertViewModel(dto,"Create","Shop",model);
            if (dto.getId() != null) {
                Helper.setUpsertViewModel(dto,"Edit","Shop",model);
            }
            return "shop/shopUpsert";
        }else{
            MultipartFile multipartFile=dto.getImage();
            String fileName=(dto.getImagePath() == null || dto.getImagePath().equals(null))? null: dto.getImagePath();
            try{
                var imagePath=fileName;
                if(!multipartFile.isEmpty()){
                    imagePath=Helper.uploadPhoto("shop",fileName,multipartFile);
                }
                Long sellerId=sellersService.findSellerId(getCurrentUser());
                dto.setImagePath(imagePath);
                shopService.add(dto,sellerId);
            }catch (Exception e){
                System.out.println("Error Upload Photo");
                Helper.setUpsertViewModel(dto,"Create","Shop",model);
                return "shop/shopUpsert";
            }
        }
        return "redirect:/home/seller?shopId="+dto.getId();
    }

    @GetMapping("profile")
    public String shopProfile(Model model,@RequestParam(required = false)Long shopId){
        if(isAccess("shop","profile")) {
            SellerBreadCrumb sellerBreadCrumb = new SellerBreadCrumb(sellersService.findSellerName(getCurrentUser()), shopService.findCurrentShop(shopId));
            model.addAttribute("currentUser", getCurrentUser());
            model.addAttribute("dto", shopService.findShopProfile(shopId, getCurrentUser()));
            model.addAttribute("shopId", shopId);
            model.addAttribute("shopList", shopService.shopListByUser(getCurrentUser(), shopId));
            model.addAttribute("sellerBreadCrumb", sellerBreadCrumb);
            return "shop/shop-profile";
        }
        return "redirect:/access-denied";
    }

    @GetMapping("/shop-detail")
    public String shopDetail(Model model,@RequestParam Long shopId){
        model.addAttribute("shopDetail",shopService.getShop(shopId));
        model.addAttribute("productList",productsService.getByShopId(shopId));
        return "/shop/shop-detail";
    }
}
