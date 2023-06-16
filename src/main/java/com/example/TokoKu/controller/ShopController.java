package com.example.TokoKu.controller;

import com.example.TokoKu.dto.display.SellerBreadCrumb;
import com.example.TokoKu.dto.upsert.ShopUpsertDto;
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
    @GetMapping("/index")
    public String shopCho(Model model){
        model.addAttribute("currentSeller",getCurrentUser());
        model.addAttribute("listShop",shopService.shopBySeller(getCurrentUser()));
        return "shop/shopCho";
    }

    @GetMapping("shopUpsert")
    public String shopUpsert(Model model, @RequestParam(required = false)Long shopId){
        ShopUpsertDto dto=new ShopUpsertDto();
        Helper.setUpsertViewModel(dto,"Create","Shop",model);
        if(shopId!=null){
            dto=shopService.findShopById(shopId);
            Helper.setUpsertViewModel(dto,"Edit","Shop",model);
        }
        return "shop/shopUpsert";
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
        SellerBreadCrumb sellerBreadCrumb=new SellerBreadCrumb(sellersService.findSellerName(getCurrentUser()),shopService.findCurrentShop(shopId));
        model.addAttribute("currentUser",getCurrentUser());
        model.addAttribute("dto",shopService.findShopProfile(shopId,getCurrentUser()));
        model.addAttribute("shopId",shopId);
        model.addAttribute("shopList",shopService.shopListByUser(getCurrentUser(),shopId));
        model.addAttribute("sellerBreadCrumb",sellerBreadCrumb);
        return "shop/shop-profile";
    }
}
